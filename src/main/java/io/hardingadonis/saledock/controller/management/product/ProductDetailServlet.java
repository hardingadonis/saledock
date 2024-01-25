package io.hardingadonis.saledock.controller.management.product;

import io.hardingadonis.saledock.model.Category;
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

        String pId = request.getParameter("id");
        
        if (pId == null) {
            response.sendRedirect(request.getContextPath() + "/404.jsp");
        } else {
            Integer idP = Integer.parseInt(pId);
            Optional<Product> product = Singleton.productDAO.getByID(idP);

            request.setAttribute("page", "product");

            if (product.isPresent()) {
                var p = product.get();
                Category cat = p.getCategory();

                request.setAttribute("pro", p);
                request.setAttribute("cat", cat);

                request.getRequestDispatcher("/view/jsp/management/product/product-detail.jsp").forward(request, response);
            } else {
                response.sendRedirect(request.getContextPath() + "/product");
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }
}
