package io.hardingadonis.saledock.dao.impl;

import io.hardingadonis.saledock.dao.*;
import io.hardingadonis.saledock.model.*;
import io.hardingadonis.saledock.utils.*;
import java.sql.*;
import java.util.*;
import org.hibernate.*;
import org.json.simple.*;

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

      PreparedStatement smt =
          conn.prepareStatement("SELECT COUNT(*) FROM `order`");

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

      PreparedStatement smt = conn.prepareStatement(
          "SELECT COUNT(*) FROM `order` WHERE `status` IN ('PENDING', 'SHIPPING')");

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
  public String statisticBySold(Integer duration) {
    JSONObject json = new JSONObject();

    try {
      Connection conn = Singleton.dbContext.getConnection();

      PreparedStatement smt = conn.prepareStatement(
          "SELECT COUNT(*), DATE_FORMAT(SUBSTR(`created_at`, 1, 10), 'Tháng %m năm %Y') FROM `order` WHERE `created_at` BETWEEN DATE_SUB(CURDATE(), INTERVAL ? MONTH) AND CURDATE() GROUP BY SUBSTR(`created_at`, 1, 7)");
      smt.setInt(1, duration);

      ResultSet rs = smt.executeQuery();

      JSONArray labels = new JSONArray();
      JSONArray dataset = new JSONArray();

      while (rs.next()) {
        Long data = rs.getLong(1);
        String label = rs.getString(2);

        labels.add(label);
        dataset.add(data);
      }

      json.put("labels", labels);
      json.put("dataset", dataset);

      Singleton.dbContext.closeConnection(conn);
    } catch (SQLException ex) {
      System.err.println(ex.getMessage());
    }

    return json.toJSONString();
  }

  @Override
  public String statisticByStatus(Integer duration) {
    JSONObject json = new JSONObject();

    try {
      Connection conn = Singleton.dbContext.getConnection();

      PreparedStatement smt = conn.prepareStatement(
          "SELECT COUNT(*), CASE WHEN `status` = 'PENDING' THEN 'Đang xử lý' WHEN `status` = 'SHIPPING' THEN 'Đang giao hàng' WHEN `status` = 'DONE' THEN 'Đã hoàn thành' WHEN `status` = 'CANCELLED' THEN 'Đã hủy' END FROM `order` WHERE `created_at` BETWEEN DATE_SUB(CURDATE(), INTERVAL ? MONTH) AND CURDATE() GROUP BY `status`");
      smt.setInt(1, duration);

      ResultSet rs = smt.executeQuery();

      JSONArray labels = new JSONArray();
      JSONArray dataset = new JSONArray();

      while (rs.next()) {
        Long data = rs.getLong(1);
        String label = rs.getString(2);

        labels.add(label);
        dataset.add(data);
      }

      json.put("labels", labels);
      json.put("dataset", dataset);

      Singleton.dbContext.closeConnection(conn);
    } catch (SQLException ex) {
      System.err.println(ex.getMessage());
    }

    return json.toJSONString();
  }
}
