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
        String customerIdParam = request.getParameter("customerId");

        if (!checkCusIdParam(customerIdParam)) {
            response.sendRedirect("./error-404");
            return;
        }

        request.getRequestDispatcher("/view/jsp/management/order/add-product-into-order.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String customerIdParam = request.getParameter("customerId");

        if (!checkCusIdParam(customerIdParam)) {
            response.sendRedirect("./error-404");
            return;
        }

        String productIdParam = request.getParameter("productId");
        String productQuantityParam = request.getParameter("productQuantity");

        if (productIdParam == null || productIdParam.isEmpty()) {
            request.setAttribute("message", "notInputProduct");
            this.doGet(request, response);
            return;
        }
        
        if (productQuantityParam == null || productQuantityParam.isEmpty()) {
            request.setAttribute("message", "notInputProductQuantity");
            this.doGet(request, response);
            return;
        }

        if (!isInteger(productIdParam)) {
            request.setAttribute("message", "productNotExist");
            this.doGet(request, response);
            return;
        }
        
        if (!isInteger(productQuantityParam)) {
            request.setAttribute("message", "productQuantityNotExist");
            this.doGet(request, response);
            return;
        }
        
        Integer productId = Integer.parseInt(productIdParam);
        Integer productQuantity = Integer.parseInt(productQuantityParam);
        
        if(productQuantity <= 0){
            request.setAttribute("message", "productQuantityNotPositive");
            this.doGet(request, response);
            return;
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
            response.sendRedirect("./add-order?customerId=" + customerIdParam + "&message=addSuccess");
        } else {
            request.setAttribute("message", "productNotExist");
            this.doGet(request, response);
        }

    }

    private boolean checkCusIdParam(String customerIdParam) {
        if (customerIdParam == null || customerIdParam.isEmpty()) {
            return true;
        }

        try {
            Integer customerId = Integer.parseInt(customerIdParam);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
    
    private boolean isInteger(String param){
        try {
            Integer.parseInt(param);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
