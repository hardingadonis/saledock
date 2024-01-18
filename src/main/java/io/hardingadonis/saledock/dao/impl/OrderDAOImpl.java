package io.hardingadonis.saledock.dao.impl;

import io.hardingadonis.saledock.dao.*;
import io.hardingadonis.saledock.model.*;
import io.hardingadonis.saledock.utils.*;
import java.util.*;
import org.hibernate.*;

public class OrderDAOImpl implements IOrderDAO {

    private final SessionFactory sessionFactory;

    public OrderDAOImpl() {
        this.sessionFactory = HibernateUtil.getSessionFactory();
    }

    @Override
    public void add(Order obj) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.persist(obj);
            session.getTransaction().commit();
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
    public void update(Order obj) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.merge(obj);
            session.getTransaction().commit();
        }
    }
}
