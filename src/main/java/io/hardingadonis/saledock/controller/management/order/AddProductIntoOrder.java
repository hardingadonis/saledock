package io.hardingadonis.saledock.controller.management.order;

import io.hardingadonis.saledock.model.*;
import io.hardingadonis.saledock.utils.*;
import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.*;
import java.io.*;
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
        
        List<Product> products = Singleton.productDAO.getAll();
        for (Product product : products) {
            if (productName.toLowerCase().equals(product.getName().toLowerCase())) {
                
            }
        }
    }
}
