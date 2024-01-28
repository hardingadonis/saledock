package io.hardingadonis.saledock.utils;

import io.hardingadonis.saledock.dao.*;
import io.hardingadonis.saledock.dao.impl.*;
import io.hardingadonis.saledock.utils.impl.*;

public class Singleton {

    public static ICategoryDAO categoryDAO;

    public static ICustomerDAO customerDAO;

    public static IEmployeeDAO employeeDAO;

    public static IOrderDAO orderDAO;

    public static IProductDAO productDAO;
    
    public static IDBContext dbContext;

    static {
        categoryDAO = new CategoryDAOImpl();
        
        customerDAO = new CustomerDAOImpl();
        
        employeeDAO = new EmployeeDAOImpl();
        
        orderDAO = new OrderDAOImpl();
        
        productDAO = new ProductDAOImpl();
        
        dbContext = new DBContextMySQLImpl();
    }

    public static CustomerDAOImpl getCustomerDAO() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
