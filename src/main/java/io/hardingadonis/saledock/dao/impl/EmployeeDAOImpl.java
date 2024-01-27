package io.hardingadonis.saledock.dao.impl;

import io.hardingadonis.saledock.dao.*;
import io.hardingadonis.saledock.model.*;
import io.hardingadonis.saledock.utils.*;
import java.util.*;
import org.hibernate.*;

public class EmployeeDAOImpl implements IEmployeeDAO {

  private final SessionFactory sessionFactory;

  public EmployeeDAOImpl() {
    this.sessionFactory = HibernateUtil.getSessionFactory();
  }

  @Override
  public Employee save(Employee obj) {
    try (Session session = sessionFactory.openSession()) {
      session.beginTransaction();
      Employee o = session.merge(obj);
      session.getTransaction().commit();

      return o;
    }
  }

  @Override
  public Optional<Employee> getByID(Integer ID) {
    try (Session session = sessionFactory.openSession()) {
      return Optional.ofNullable(session.get(Employee.class, ID));
    }
  }

  @Override
  public List<Employee> getAll() {
    try (Session session = sessionFactory.openSession()) {
      return session.createQuery("FROM Employee", Employee.class)
          .getResultList();
    }
  }

  @Override
  public Optional<Employee> getByCode(String code) {
    try (Session session = sessionFactory.openSession()) {
      String hql = "FROM Employee WHERE code = :code";
      return Optional.ofNullable(session.createQuery(hql, Employee.class)
                                     .setParameter("code", code)
                                     .uniqueResult());
    }
  }

  @Override
  public boolean insert(Employee customer) {

    return false;
  }
}
