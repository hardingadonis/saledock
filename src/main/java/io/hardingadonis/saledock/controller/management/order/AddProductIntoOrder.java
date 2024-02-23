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
        
        String customerName = (String) SessionUtil.getInstance().getValue(request, "customerName");
        String employeeName = (String) SessionUtil.getInstance().getValue(request, "employeeName");
        
        request.setAttribute("customerName", customerName);
        request.setAttribute("employeeName", employeeName);
        
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
            Cookie productCookie = new Cookie("product", product.get().getID() + ":" + productQuantity);
            productCookie.setMaxAge(3600);
            response.addCookie(productCookie);
            
            request.getRequestDispatcher("/view/jsp/management/order/add-order.jsp").forward(request, response);           
        }
    }
}
