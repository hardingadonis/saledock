package io.hardingadonis.saledock.controller.management.customer;

import io.hardingadonis.saledock.model.Customer;
import io.hardingadonis.saledock.utils.Singleton;
import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.*;

import java.io.*;
import java.util.Optional;

@WebServlet(name = "UpdateCustomerServlet", urlPatterns = {"/update-customer"})
public class UpdateCustomerServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");

        request.setAttribute("page", "customer");

        String id = request.getParameter("id");
        if (id == null) {
            response.sendError(404);
            return;
        }

        Integer id_customer = Integer.valueOf(id);
        Optional<Customer> customer = Singleton.customerDAO.getByID(id_customer);

        if (customer.isPresent()) {
            var cus = customer.get();

            request.setAttribute("cus", cus);
            request.getRequestDispatcher("/view/jsp/management/customer/update-customer.jsp").forward(request, response);
        } else {
            response.sendRedirect(request.getContextPath() + "/customer");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");

        System.out.println("hhhh");
        String name = request.getParameter("nameCus");
        String address = request.getParameter("addressCus");

        String id = request.getParameter("id");
        if (id == null) {
            response.sendError(404);
            return;
        }
        

        Integer id_customer = Integer.valueOf(id);
        Customer customer = Singleton.customerDAO.getByID(id_customer).get();
        if (!name.isEmpty()) {
            customer.setName(name);
        }
        if (!address.isEmpty()) {
            customer.setAddress(address);
        }
        Singleton.customerDAO.save(customer);
        response.sendRedirect(request.getContextPath() + "/customer-detail?id="+id);
    }
}
