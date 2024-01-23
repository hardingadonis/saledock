package io.hardingadonis.saledock.dao.impl;

import io.hardingadonis.saledock.dao.*;
import io.hardingadonis.saledock.model.*;
import io.hardingadonis.saledock.utils.*;
import java.sql.*;
import java.util.*;
import org.hibernate.*;

public class OrderDAOImpl implements IOrderDAO {

    private final SessionFactory sessionFactory;

    public OrderDAOImpl() {
        this.sessionFactory = HibernateUtil.getSessionFactory();
    }

    @Override
    public Order save(Order obj) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            Order o = session.merge(obj);
            session.getTransaction().commit();

            return o;
        }
    }

    @Override
    public Optional<Order> getByID(Integer ID) {
        try (Session session = sessionFactory.openSession()) {
            return Optional.ofNullable(session.get(Order.class, ID));
        }
    }

    @Override
    public List<Order> getAll() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("FROM Order", Order.class).getResultList();
        }
    }

    @Override
    public Long count() {
        Long count = 0L;

        try {
            Connection conn = Singleton.dbContext.getConnection();

            PreparedStatement smt = conn.prepareStatement("SELECT COUNT(*) FROM `order`");

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
    public Long countOrderInProcess() {
        Long count = 0L;

        try {
            Connection conn = Singleton.dbContext.getConnection();

            PreparedStatement smt = conn.prepareStatement("SELECT COUNT(*) FROM `order` WHERE `status` IN ('PENDING', 'SHIPPING')");

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
