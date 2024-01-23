package io.hardingadonis.saledock.controller.management.product;

import io.hardingadonis.saledock.model.Product;
import io.hardingadonis.saledock.utils.Singleton;
import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.*;
import java.util.Optional;

@WebServlet(name = "ProductDetailServlet", urlPatterns = {"/product-detail"})
public class ProductDetailServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        
        //        Integer idP = (Integer) request.getAttribute("");
        
        Optional<Product> product = Singleton.productDAO.getByID(2);
        
        request.setAttribute("page", "dashboard");
        request.setAttribute("product", product);

        request.getRequestDispatcher("./view/jsp/management/product/product-detail.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }
}
