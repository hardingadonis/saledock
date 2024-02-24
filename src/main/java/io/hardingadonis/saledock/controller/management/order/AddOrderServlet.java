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
        List<Product> products = Singleton.productDAO.getAll();

        String customerNameParam = request.getParameter("customerName");

        if (customerNameParam != null) {
            customerNameParam = URLDecoder.decode(customerNameParam, "UTF-8");
        }

        Map<Integer, Integer> productMap = (Map<Integer, Integer>) SessionUtil.getInstance().getValue(request, "productMap");
        if (productMap == null) {
            productMap = new HashMap<>();
            SessionUtil.getInstance().putValue(request, "productMap", productMap);
        }

        request.setAttribute("customers", customers);
        request.setAttribute("products", products);
        request.setAttribute("customerNameParam", customerNameParam);
        request.setAttribute("productMap", productMap);

        request.setAttribute("page", "order");

        request.getRequestDispatcher("/view/jsp/management/order/add-order.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String customerName = request.getParameter("customerName");
    }
}
