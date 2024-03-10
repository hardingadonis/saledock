package io.hardingadonis.saledock.controller.management.customer;

import io.hardingadonis.saledock.model.*;
import io.hardingadonis.saledock.utils.*;
import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.*;
import java.util.*;

@WebServlet(name = "CustomerServlet", urlPatterns = {"/customer"})
public class CustomerServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");

        int pageNumber = 1;
        int pageSize = 10;

        if (request.getParameter("page") != null) {
            try {
                pageNumber = Integer.parseInt(request.getParameter("page"));
            } catch (Exception e) {
                response.sendRedirect("./error-404");
                return;
            }
        }

        List<Customer> customers = Singleton.customerDAO.pagination((pageNumber - 1) * pageSize, pageSize);

        int totalPages = Singleton.customerDAO.totalPages(pageSize);

        request.setAttribute("pageSize", pageSize);

        request.setAttribute("customerCount", Singleton.customerDAO.count());
        request.setAttribute("customers", customers);
        request.setAttribute("currentPage", pageNumber);
        request.setAttribute("totalPages", totalPages);
        request.setAttribute("pageSize", pageSize);
        request.setAttribute("page", "customer");

        request.getRequestDispatcher("/view/jsp/management/customer/customer.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }
}
