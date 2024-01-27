package io.hardingadonis.saledock.utils;

import java.sql.*;

public interface IDBContext {

  public Connection getConnection();

  public void closeConnection(Connection connection);
}
