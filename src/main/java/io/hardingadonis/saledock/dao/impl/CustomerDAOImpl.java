package io.hardingadonis.saledock.dao.impl;

import io.hardingadonis.saledock.dao.*;
import io.hardingadonis.saledock.model.*;
import io.hardingadonis.saledock.utils.*;
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
}
