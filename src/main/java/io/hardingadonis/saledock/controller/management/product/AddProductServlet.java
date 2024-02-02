package io.hardingadonis.saledock.controller.management.product;

import java.io.*;

import io.hardingadonis.saledock.model.Category;
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

        request.setAttribute("page", "product");

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/view/jsp/management/product/add-product.jsp");
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	 String categoryID = request.getParameter("categoryID");
         String code = request.getParameter("code");
         String description = request.getParameter("description");
         String name = request.getParameter("name");
         String price = request.getParameter("price");

         
         if(categoryID==null || code==null || price==null) {
         	response.sendError(404, "Please provide Category ID, Product Code and Price");
         	return;
         }
         
         Integer id_category = Integer.valueOf(categoryID);
         
         Category category = Singleton.categoryDAO.getByID(id_category).orElse(null);
         
         if(category==null) {
         	response.sendError(404, "Please provide correct Category ID");
         	return;
         }
         
         Product product = new Product();
         product.setCategory(category);
         product.setCode(code);
         product.setDescription(description);
         product.setName(name);
         product.setPrice(Double.valueOf(price));
         
         Singleton.productDAO.save(product);
        
         response.sendRedirect(request.getContextPath() + "/product");
         return;
     }
    }

