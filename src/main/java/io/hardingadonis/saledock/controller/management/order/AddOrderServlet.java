package io.hardingadonis.saledock.controller.management.order;

import java.io.*;

import io.hardingadonis.saledock.model.Customer;
import io.hardingadonis.saledock.model.Employee;
import io.hardingadonis.saledock.model.Order;
import io.hardingadonis.saledock.model.Product;
import io.hardingadonis.saledock.utils.Singleton;
import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.*;

@WebServlet(name = "AddOrderServlet", urlPatterns = {"/add-order"})
public class AddOrderServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	 request.setCharacterEncoding("UTF-8");
         response.setContentType("text/html; charset=UTF-8");

         request.setAttribute("page", "order");

         RequestDispatcher requestDispatcher = request.getRequestDispatcher("/view/jsp/management/order/add-order.jsp");
         requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String customerID = request.getParameter("customerID");
        String productID = request.getParameter("productID");
        String quantity = request.getParameter("quantity");
        
        if(customerID==null || productID==null || quantity==null) {
        	response.sendError(404, "Please provide Customer ID, Product ID and Quantity");
        	return;
        }
        
        Integer id_customer = Integer.valueOf(customerID);
        Integer id_product = Integer.valueOf(productID);
        
        Customer customer = Singleton.customerDAO.getByID(id_customer).orElse(null);
        Product product = Singleton.productDAO.getByID(id_product).orElse(null);
        HttpSession session = request.getSession();
        Employee employee = (Employee) session.getAttribute("employee");

        // Check if an employee is logged in
        if (employee == null) {
            response.sendRedirect(request.getContextPath() + "/login?message=notLoggedIn");
            return;
        }
        
        if(customer==null|| product==null) {
        	response.sendError(404, "Please provide correct Customer ID and Product ID");
        	return;
        }
        
        Order order = new Order();
        order.setCustomer(customer);
        order.setEmployee(employee);
        
        order.addProduct(product, Integer.valueOf(quantity));
        
        Singleton.orderDAO.save(order);
        response.sendRedirect(request.getContextPath() + "/order");
        return;
    }
   
}
