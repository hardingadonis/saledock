package io.hardingadonis.saledock.controller.management.customer;
import io.hardingadonis.saledock.model.*;
import io.hardingadonis.saledock.model.Customer;
import io.hardingadonis.saledock.utils.Singleton;
import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.*;
import java.util.List;
import java.util.*;
import io.hardingadonis.saledock.utils.*;


@WebServlet(name = "CustomerServlet", urlPatterns = {"/customer"})
public class CustomerServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        
        List<Customer> customers = Singleton.customerDAO.getAll();
        request.setAttribute("customers", customers);
        request.setAttribute("page","customer");
        
        request.getRequestDispatcher("/view/jsp/management/customer/customer.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }
}
