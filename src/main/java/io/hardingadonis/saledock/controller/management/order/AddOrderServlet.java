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
        String action = request.getParameter("action");

        if (action != null) {
            switch (action) {
                case "delete":
                    deleteProductFromOrder(request, response);
                    break;
                default:
                    response.sendRedirect("./add-product");
            }
        }

        if (customerNameParam != null) {
            customerNameParam = URLDecoder.decode(customerNameParam, "UTF-8");
        }

        Map<Integer, Integer> productMap = getProductMap(request);

        double totalCost = calculateTotalCost(productMap, Singleton.productDAO.getAll());

        request.setAttribute("customers", customers);
        request.setAttribute("products", products);
        request.setAttribute("customerNameParam", customerNameParam);
        request.setAttribute("productMap", productMap);
        request.setAttribute("totalCost", totalCost);

        request.setAttribute("page", "order");

        request.getRequestDispatcher("/view/jsp/management/order/add-order.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String customerName = request.getParameter("customerName");
    }

    private void deleteProductFromOrder(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String productIdParam = request.getParameter("productId");

        if (productIdParam != null) {
            try {
                int productId = Integer.parseInt(productIdParam);

                Map<Integer, Integer> productMap = getProductMap(request);

                productMap.remove(productId);

                double totalCost = calculateTotalCost(productMap, Singleton.productDAO.getAll());
                request.setAttribute("totalCost", totalCost);

                SessionUtil.getInstance().putValue(request, "productMap", productMap);
                
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
    }

    private Map<Integer, Integer> getProductMap(HttpServletRequest request) {
        Map<Integer, Integer> productMap = (Map<Integer, Integer>) SessionUtil.getInstance().getValue(request, "productMap");
        if (productMap == null) {
            productMap = new HashMap<>();
            SessionUtil.getInstance().putValue(request, "productMap", productMap);
        }
        return productMap;
    }

    private double calculateTotalCost(Map<Integer, Integer> productMap, List<Product> allProducts) {
        double totalCost = 0;

        for (Map.Entry<Integer, Integer> entry : productMap.entrySet()) {
            int productId = entry.getKey();
            int quantity = entry.getValue();

            for (Product product : allProducts) {
                if (product.getID() == productId) {
                    totalCost += product.getPrice() * quantity;
                    break;
                }
            }
        }

        return totalCost;
    }
}
