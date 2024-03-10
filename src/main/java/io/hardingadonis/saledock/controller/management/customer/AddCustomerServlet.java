package io.hardingadonis.saledock.controller.management.customer;

import io.hardingadonis.saledock.model.*;
import io.hardingadonis.saledock.utils.*;
import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.*;
import java.sql.SQLException;

@WebServlet(name = "AddCustomerServlet", urlPatterns = {"/add-customer"})
public class AddCustomerServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");

        request.setAttribute("page", "customer");

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/view/jsp/management/customer/add-customer.jsp");
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("name");
        String code = request.getParameter("code");
        String address = request.getParameter("address");
        String email = request.getParameter("email");

        try {
            if (name.length() > 0 && code.length() > 0 && address.length() > 0 && email.length() > 0) {
                Customer customer = new Customer();
                customer.setName(name);
                customer.setCode(code);
                customer.setAddress(address);
                customer.setEmail(email);
                Singleton.customerDAO.save(customer);

                response.sendRedirect(request.getContextPath() + "/customer");
                return;
            }
        } catch (Exception e) {
            Customer customer = new Customer();
            customer.setName(name);
            customer.setAddress(address);
            StringBuilder message = new StringBuilder("Tạo khách hàng không thành công: ");
            if (e.getMessage().contains(code)) {
                message.append("Không được trùng mã khách hàng.");
            }
            if (e.getMessage().contains(email)) {
                message.append("Không được trùng email.");
            }
            request.setAttribute("error", message.toString());
            request.setAttribute("appendCustomer", customer);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/view/jsp/management/customer/add-customer.jsp");
            requestDispatcher.forward(request, response);

        }

    }
}
