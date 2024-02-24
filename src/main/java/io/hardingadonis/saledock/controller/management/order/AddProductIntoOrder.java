package io.hardingadonis.saledock.controller.management.order;

import io.hardingadonis.saledock.model.*;
import io.hardingadonis.saledock.utils.*;
import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.*;
import java.io.*;
import java.net.*;
import java.util.*;

@WebServlet(name = "AddProductIntoOrder", urlPatterns = {"/add-product-into-order"})
public class AddProductIntoOrder extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Product> products = Singleton.productDAO.getAll();
        request.setAttribute("products", products);

        request.getRequestDispatcher("/view/jsp/management/order/add-product-into-order.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String productName = request.getParameter("productName").trim();
        Integer productQuantity = Integer.parseInt(request.getParameter("productQuantity"));

        Optional<Product> product = Singleton.productDAO.getByName(productName);

        if (product.isPresent()) {
            Order order = (Order) SessionUtil.getInstance().getValue(request, "order");
            if (order == null) {
                order = new Order();
                SessionUtil.getInstance().putValue(request, "order", order);
            }

            order.addProduct(product.get(), productQuantity);

            String customerName = request.getParameter("customerName");
            String employeeName = request.getParameter("employeeName");
            response.sendRedirect("./add-order?customerName=" + URLEncoder.encode(customerName, "UTF-8") + "&employeeName=" + URLEncoder.encode(employeeName, "UTF-8"));
        }
    }
}
