package io.hardingadonis.saledock.dao.impl;

import io.hardingadonis.saledock.dao.*;
import io.hardingadonis.saledock.model.*;
import io.hardingadonis.saledock.utils.*;
import java.util.*;
import org.hibernate.*;

public class CategoryDAOImpl implements ICategoryDAO {

    private final SessionFactory sessionFactory;

    public CategoryDAOImpl() {
        this.sessionFactory = HibernateUtil.getSessionFactory();
    }

    @Override
    public void add(Category obj) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.persist(obj);
            session.getTransaction().commit();
        }
    }

    @Override
    public Optional<Category> getByID(Integer ID) {
        try (Session session = sessionFactory.openSession()) {
            return Optional.ofNullable(session.get(Category.class, ID));
        }
    }

    @Override
    public List<Category> getAll() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("FROM Category", Category.class).getResultList();
        }
    }

    @Override
    public void update(Category obj) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.merge(obj);
            session.getTransaction().commit();
        }
    }
}
