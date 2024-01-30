package io.hardingadonis.saledock.controller.management.product;

import io.hardingadonis.saledock.model.Product;
import io.hardingadonis.saledock.utils.Singleton;
import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.*;
import java.util.List;

@WebServlet(name = "ProductServlet", urlPatterns = {"/product"})
public class ProductServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");

        List<Product> products = Singleton.productDAO.getAll();
        request.setAttribute("products", products);
        request.setAttribute("page", "product");

        request.getRequestDispatcher("/view/jsp/management/product/product.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }
}
