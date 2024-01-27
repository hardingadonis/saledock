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
    public Category save(Category obj) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            Category o = session.merge(obj);
            session.getTransaction().commit();

            return o;
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
    public boolean insert (Category customer){
        
        return false;
    }
}
