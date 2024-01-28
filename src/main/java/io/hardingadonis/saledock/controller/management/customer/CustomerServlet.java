package io.hardingadonis.saledock.controller.management.customer;

import io.hardingadonis.saledock.dao.impl.CustomerDAOImpl;
import io.hardingadonis.saledock.model.Customer;
import io.hardingadonis.saledock.utils.Singleton;
import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.*;
import java.util.List;

@WebServlet(name = "CustomerServlet", urlPatterns = {"/customer"})
public class CustomerServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");

        CustomerDAOImpl customerDAO = Singleton.getCustomerDAO();

        List<Customer> customers = customerDAO.getAll();

        request.setAttribute("customers", customers);

        request.getRequestDispatcher("/view/jsp/management/customer/customer.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }
}
