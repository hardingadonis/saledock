package io.hardingadonis.saledock.controller.management.order;

import io.hardingadonis.saledock.model.*;
import io.hardingadonis.saledock.utils.*;
import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.*;
import java.io.*;
import java.util.*;

@WebServlet(name = "AddOrderServlet", urlPatterns = {"/add-order"})
public class AddOrderServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        
        List<Customer> customers = Singleton.customerDAO.getAll();
        List<Employee> employees = Singleton.employeeDAO.getAll();
        List<Product> products = Singleton.productDAO.getAll();
        
        request.setAttribute("customers", customers);
        request.setAttribute("employees", employees);
        request.setAttribute("products", products);

        request.setAttribute("page", "order");

        request.getRequestDispatcher("/view/jsp/management/order/add-order.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        
        
    }
}
