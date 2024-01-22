package io.hardingadonis.saledock.dao.impl;

import io.hardingadonis.saledock.dao.*;
import io.hardingadonis.saledock.model.*;
import io.hardingadonis.saledock.utils.*;
import java.sql.*;
import java.util.*;
import org.hibernate.*;

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
}
