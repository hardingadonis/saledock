package io.hardingadonis.saledock.utils;

import lombok.Getter;
import org.hibernate.*;
import org.hibernate.cfg.*;

public class HibernateUtil {

    @Getter
    private static final SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        try {
            return new Configuration().configure().buildSessionFactory();
        } catch (HibernateException ex) {
            System.err.println(ex.getMessage());

            return null;
        }
    }

    public static void shutdown() {
        getSessionFactory().close();
    }
}
