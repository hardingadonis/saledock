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
        Integer productId = Integer.parseInt(request.getParameter("productId"));
        Integer productQuantity = Integer.parseInt(request.getParameter("productQuantity"));
        Integer customerId = Integer.parseInt(request.getParameter("customerId"));
        
        if (productId == null) {
            request.setAttribute("message", "notInputProduct");
            this.doGet(request, response);
        }
        
        if (productQuantity == null) {
            request.setAttribute("message", "notInputProduct");
            this.doGet(request, response);
        }

        Optional<Product> product = Singleton.productDAO.getByID(productId);

        if (product.isPresent()) {
            Map<Integer, Integer> productMap = (Map<Integer, Integer>) SessionUtil.getInstance().getValue(request, "productMap");

            if (productMap == null) {
                productMap = new HashMap<>();
                SessionUtil.getInstance().putValue(request, "productMap", productMap);
            }
            
            if (productMap.containsKey(productId)) {
                Integer currentQuantity = productMap.get(productId);
                productMap.put(productId, currentQuantity + productQuantity);
            } else {
                productMap.put(productId, productQuantity);
            }

            SessionUtil.getInstance().putValue(request, "productMap", productMap);
            response.sendRedirect("./add-order?customerId=" + customerId + "&message=addSuccess");
        } else {
            request.setAttribute("message", "productNotExist");
            this.doGet(request, response);
        }

    }
}
