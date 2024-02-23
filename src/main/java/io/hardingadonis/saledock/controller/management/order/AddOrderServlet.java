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
        
        request.setAttribute("customers", customers);
        request.setAttribute("employees", employees);
        
        String customerName = (String) SessionUtil.getInstance().getValue(request, "customerName");
        String employeeName = (String) SessionUtil.getInstance().getValue(request, "employeeName");
        
        request.setAttribute("customerName", customerName);
        request.setAttribute("employeeName", employeeName);

        request.setAttribute("page", "order");

        request.getRequestDispatcher("/view/jsp/management/order/add-order.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String customerName = request.getParameter("customerName");
        String employeeName = request.getParameter("employeeName");
        String employeeCode = request.getParameter("employeeCode");
        
        SessionUtil.getInstance().putValue(request, "customerName", customerName);
        SessionUtil.getInstance().putValue(request, "employeeName", employeeName);
        
        
    }
}
