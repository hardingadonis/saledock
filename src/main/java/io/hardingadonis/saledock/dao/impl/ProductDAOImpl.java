package io.hardingadonis.saledock.dao.impl;

import io.hardingadonis.saledock.dao.*;
import io.hardingadonis.saledock.model.*;
import io.hardingadonis.saledock.utils.*;
import java.sql.*;
import java.util.*;
import org.hibernate.*;
import org.json.simple.*;

public class ProductDAOImpl implements IProductDAO {

    private final SessionFactory sessionFactory;

    public ProductDAOImpl() {
        this.sessionFactory = HibernateUtil.getSessionFactory();
    }

    @Override
    public Product save(Product obj) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            Product o = session.merge(obj);
            session.getTransaction().commit();

            return o;
        }
    }

    @Override
    public Optional<Product> getByID(Integer ID) {
        try (Session session = sessionFactory.openSession()) {
            return Optional.ofNullable(session.get(Product.class, ID));
        }
    }

    @Override
    public List<Product> getAll() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("FROM Product", Product.class).getResultList();
        }
    }
    
    @Override
    public Long count() {
        Long count = 0L;

        try {
            Connection conn = Singleton.dbContext.getConnection();

            PreparedStatement smt = conn.prepareStatement("SELECT COUNT(*) FROM `product`");

            ResultSet rs = smt.executeQuery();

            if (rs.next()) {
                count = rs.getLong(1);
            }

            Singleton.dbContext.closeConnection(conn);
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

        return count;
    }
    
    @Override
    public String getTop10(Integer duration) {
        JSONObject json = new JSONObject();

        try {
            Connection conn = Singleton.dbContext.getConnection();

            PreparedStatement smt = conn.prepareStatement("SELECT `p`.`name`, SUM(`od`.`quantity`) AS `count` FROM `order_detail` `od` JOIN `order` `o` ON `o`.`id` = `od`.`order_id` JOIN `product` `p` ON `p`.`id` = `od`.`product_id` WHERE `o`.`created_at` BETWEEN DATE_SUB(CURDATE(), INTERVAL ? MONTH) AND CURDATE() GROUP BY `p`.`id` ORDER BY `count` DESC LIMIT 10;");
            smt.setInt(1, duration);

            ResultSet rs = smt.executeQuery();

            JSONArray labels = new JSONArray();
            JSONArray dataset = new JSONArray();

            while (rs.next()) {
                String label = rs.getString(1);
                Long data = rs.getLong(2);

                labels.add(label);
                dataset.add(data);
            }

            json.put("labels", labels);
            json.put("dataset", dataset);

            Singleton.dbContext.closeConnection(conn);
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

        System.out.println(json.toJSONString());

        return json.toJSONString();
    }
    
    

}
