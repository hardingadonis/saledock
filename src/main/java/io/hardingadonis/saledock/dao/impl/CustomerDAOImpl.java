package io.hardingadonis.saledock.dao.impl;

import io.hardingadonis.saledock.dao.*;
import io.hardingadonis.saledock.model.*;
import io.hardingadonis.saledock.utils.*;
import java.sql.*;
import java.util.*;
import org.hibernate.*;

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
    public Long count() {
        Long count = 0L;

        try {
            Connection conn = Singleton.dbContext.getConnection();

            PreparedStatement smt = conn.prepareStatement("SELECT COUNT(*) FROM `customer`");

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
