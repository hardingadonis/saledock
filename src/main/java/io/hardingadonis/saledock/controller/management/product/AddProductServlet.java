package io.hardingadonis.saledock.controller.management.product;

import java.io.*;
import java.util.List;
import java.util.Optional;

import io.hardingadonis.saledock.model.Category;
import io.hardingadonis.saledock.model.Customer;
import io.hardingadonis.saledock.model.Product;
import io.hardingadonis.saledock.utils.Singleton;
import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.*;

@WebServlet(name = "AddProductServlet", urlPatterns = {"/add-product"})
public class AddProductServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	  request.setCharacterEncoding("UTF-8");
          response.setContentType("text/html; charset=UTF-8");
          List<Category> categories=Singleton.categoryDAO.getAll();
          request.setAttribute("categories", categories);
          
          request.setAttribute("page", "product");

          RequestDispatcher requestDispatcher = request.getRequestDispatcher("/view/jsp/management/product/add-product.jsp");
          requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	  String name = request.getParameter("name");
          String code = request.getParameter("code");
          String category_id = request.getParameter("category");
          String description = request.getParameter("description");
          String price = request.getParameter("price");
          
          Double d=Double.parseDouble(price);

          if (name.length() > 0 && code.length() > 0 && category_id.length()>0 && description.length() > 0 && price.length() > 0) {
            Product product =new Product();
               product.setName(name);
               product.setCode(code);
               product.setDescription(description);
              product.setPrice(d);
              
              Optional<Category> productCategory=Singleton.categoryDAO.getByID(Integer.parseInt(category_id));
              product.setCategory(productCategory.get());
              Singleton.productDAO.save(product);

              response.sendRedirect(request.getContextPath() + "/product");
              return;
          }

          response.sendRedirect(request.getContextPath() + "/add-product");
    }
}
