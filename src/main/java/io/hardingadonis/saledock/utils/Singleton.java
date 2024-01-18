package io.hardingadonis.saledock.utils;

import io.hardingadonis.saledock.dao.*;
import io.hardingadonis.saledock.dao.impl.*;

public class Singleton {

    public static ICategoryDAO categoryDAO;

    public static ICustomerDAO customerDAO;

    public static IEmployeeDAO employeeDAO;

    public static IOrderDAO orderDAO;

    public static IProductDAO productDAO;

    static {
        categoryDAO = new CategoryDAOImpl();
        
        customerDAO = new CustomerDAOImpl();
        
        employeeDAO = new EmployeeDAOImpl();
        
        orderDAO = new OrderDAOImpl();
        
        productDAO = new ProductDAOImpl();
    }
}
