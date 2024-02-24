package io.hardingadonis.saledock.controller.management.order;

import io.hardingadonis.saledock.model.*;
import io.hardingadonis.saledock.utils.*;
import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.*;
import java.io.*;
import java.net.*;
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

        String customerNameParam = request.getParameter("customerName");
        String employeeNameParam = request.getParameter("employeeName");

        if (customerNameParam != null) {
            customerNameParam = URLDecoder.decode(customerNameParam, "UTF-8");
        }

        if (employeeNameParam != null) {
            employeeNameParam = URLDecoder.decode(employeeNameParam, "UTF-8");
        }
        
        Order order = (Order) SessionUtil.getInstance().getValue(request, "order");

        if (order == null) {
            order = new Order();
            SessionUtil.getInstance().putValue(request, "order", order);
        }

        request.setAttribute("customers", customers);
        request.setAttribute("employees", employees);
        request.setAttribute("customerNameParam", customerNameParam);
        request.setAttribute("employeeNameParam", employeeNameParam);
        request.setAttribute("order", order);
        
        request.setAttribute("page", "order");

        request.getRequestDispatcher("/view/jsp/management/order/add-order.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String customerName = request.getParameter("customerName");
        String employeeName = request.getParameter("employeeName");
        String employeeCode = request.getParameter("employeeCode");
    }
}
