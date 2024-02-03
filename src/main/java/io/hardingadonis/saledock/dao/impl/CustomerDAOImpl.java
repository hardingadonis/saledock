package io.hardingadonis.saledock.dao.impl;

import io.hardingadonis.saledock.dao.*;
import io.hardingadonis.saledock.model.*;
import io.hardingadonis.saledock.utils.*;
import java.sql.*;
import java.util.*;
import org.hibernate.*;
import org.hibernate.query.*;
import org.json.simple.*;

public class CustomerDAOImpl implements ICustomerDAO {

    private final SessionFactory sessionFactory;

    public CustomerDAOImpl() {
        this.sessionFactory = HibernateUtil.getSessionFactory();
    }

    @Override
    public Customer save(Customer obj) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            Customer o = session.merge(obj);
            session.getTransaction().commit();

            return o;
        }
    }

    @Override
    public Optional<Customer> getByID(Integer ID) {
        try (Session session = sessionFactory.openSession()) {
            return Optional.ofNullable(session.get(Customer.class, ID));
        }
    }

    @Override
    public List<Customer> getAll() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("FROM Customer", Customer.class).getResultList();
        }
    }

    @Override
    public Integer count() {
        Integer count = 0;

        try {
            Connection conn = Singleton.dbContext.getConnection();

            PreparedStatement smt = conn.prepareStatement("SELECT COUNT(*) FROM `customer`");

            ResultSet rs = smt.executeQuery();

            if (rs.next()) {
                count = rs.getInt(1);
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

            PreparedStatement smt = conn.prepareStatement("SELECT `c`.`name`, COUNT(`o`.`id`) AS `count` FROM `customer` `c` JOIN `order` `o` ON `c`.`id` = `o`.`customer_id` WHERE `o`.`created_at` BETWEEN DATE_SUB(CURDATE(), INTERVAL ? MONTH) AND CURDATE() GROUP BY `c`.`id` ORDER BY `count` DESC LIMIT 10;");
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

    @Override
    public List<Customer> pagination(Integer offset, Integer limit) {
        try (Session session = sessionFactory.openSession()) {
            Query<Customer> query = session.createQuery("FROM Customer", Customer.class);
            query.setFirstResult(offset);
            query.setMaxResults(limit);

            return query.getResultList();
        }
    }
}
