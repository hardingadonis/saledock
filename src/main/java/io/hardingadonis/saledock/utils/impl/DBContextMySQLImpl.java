package io.hardingadonis.saledock.utils.impl;

import java.io.*;
import java.sql.*;
import java.util.*;

import io.hardingadonis.saledock.utils.*;

public class DBContextMySQLImpl implements IDBContext {

    private String dbURL;
    private String user;
    private String password;

    public DBContextMySQLImpl() {
        try (InputStream input = DBContextMySQLImpl.class.getClassLoader().getResourceAsStream("config.mysql.properties")) {
            Properties prop = new Properties();

            if (input == null) {
                this.dbURL = "jdbc:mysql://localhost:3306/saledock";
                this.user = "root";
                this.password = "root";
            } else {
                prop.load(input);

                this.dbURL = "jdbc:mysql://" + prop.getProperty("config.jdbc.url") + ":3306/" + prop.getProperty("config.jdbc.database_name");
                this.user = prop.getProperty("config.jdbc.user");
                this.password = prop.getProperty("config.jdbc.password");
            }
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
    }

    @Override
    public Connection getConnection() {
        Connection connection = null;

        try {
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());

            connection = DriverManager.getConnection(this.dbURL, this.user, this.password);

            System.out.println("Connect MySQL successfully!");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

        return connection;
    }

    @Override
    public void closeConnection(Connection connection) {
        try {
            if (connection != null) {
                connection.close();

                System.out.println("Close MySQL successfully!");
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
}
