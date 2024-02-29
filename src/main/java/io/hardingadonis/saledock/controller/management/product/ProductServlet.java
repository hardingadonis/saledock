package io.hardingadonis.saledock.controller.management.product;

import io.hardingadonis.saledock.model.*;
import io.hardingadonis.saledock.utils.*;
import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.*;
import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

@WebServlet(name = "ProductServlet", urlPatterns = {"/product"})
public class ProductServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");

        List<Product> products = Singleton.productDAO.getAll();
//        List<Product> sortListP = products.stream().sorted(Comparator.comparing(Product::getID).reversed()).collect(Collectors.toList());

        int page = 1;
        int limit = 20;

        if (request.getParameter("page") != null) {
            page = Integer.parseInt(request.getParameter("page"));
        }

        List<Product> list = Singleton.productDAO.pagination((page - 1) * limit, limit);
        Integer count = Singleton.productDAO.count();

        int totalPage = count / limit;
        if (count % limit != 0) {
            totalPage++;
        }

        request.setAttribute("productList", list);
        request.setAttribute("currentPage", page);
        request.setAttribute("totalPage", totalPage);
        request.setAttribute("numOfPro", count);
        request.setAttribute("limit", limit);

        request.setAttribute("page", "product");

        request.getRequestDispatcher("/view/jsp/management/product/product.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }
}
