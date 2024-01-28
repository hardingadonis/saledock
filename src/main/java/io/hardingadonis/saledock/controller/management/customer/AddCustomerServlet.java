package io.hardingadonis.saledock.controller.management.customer;


import io.hardingadonis.saledock.model.Customer;
import io.hardingadonis.saledock.utils.Singleton;
import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.*;


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

            if (name.length() > 0 && code.length() > 0  && address.length() > 0  && email.length() > 0 ) {
                Customer customer = new Customer();
                customer.setName(name);
                customer.setCode(code);
                customer.setAddress(address);
                customer.setEmail(email);
                Singleton.customerDAO.save(customer);
                
                response.sendRedirect("./customer");
                
            }
            response.sendRedirect("./add-customer");

       

    }
}
