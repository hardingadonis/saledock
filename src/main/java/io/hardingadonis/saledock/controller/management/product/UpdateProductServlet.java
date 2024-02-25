package io.hardingadonis.saledock.controller.management.product;

import io.hardingadonis.saledock.model.*;

import io.hardingadonis.saledock.utils.Singleton;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

@WebServlet(name = "UpdateProductServlet", urlPatterns = {"/update-product"})
public class UpdateProductServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        request.setAttribute("page", "product");

        String pId = request.getParameter("id");

        if (pId == null) {
            response.sendError(404);

            return;
        }

        Integer idP = Integer.valueOf(pId);
        Optional<Product> product = Singleton.productDAO.getByID(idP);

        request.setAttribute("page", "product");

        if (product.isPresent()) {
            var p = product.get();
            Category cat = p.getCategory();

            request.setAttribute("pro", p);
            request.setAttribute("cat", cat);

            request.getRequestDispatcher("/view/jsp/management/product/update-product.jsp").forward(request, response);
        } else {
            response.sendRedirect(request.getContextPath() + "/product");
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String pId = request.getParameter("id");

        if (pId == null) {
            response.sendError(404);

            return;
        }
        Integer idP = Integer.valueOf(pId);
        String productName = request.getParameter("productName");
        String productDescription = request.getParameter("productDescription");
        double price = Double.parseDouble(request.getParameter("price"));

        Product product = Singleton.productDAO.getByID(idP).get();
        product.setPrice(price);
        product.setName(productName);
        product.setDescription(productDescription);

        Singleton.productDAO.save(product);

        response.sendRedirect("./product");
    }

}
