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
            Map<Integer, Integer> productMap = (Map<Integer, Integer>) SessionUtil.getInstance().getValue(request, "productMap");

            if (productMap == null) {
                productMap = new HashMap<>();
                SessionUtil.getInstance().putValue(request, "productMap", productMap);
            }

            Integer productId = product.get().getID();

            if (productMap.containsKey(productId)) {
                Integer currentQuantity = productMap.get(productId);
                productMap.put(productId, currentQuantity + productQuantity);
            } else {
                productMap.put(productId, productQuantity);
            }

            SessionUtil.getInstance().putValue(request, "productMap", productMap);
            String customerName = request.getParameter("customerName");
            response.sendRedirect("./add-order?customerName=" + URLEncoder.encode(customerName, "UTF-8"));
        }

    }
}
