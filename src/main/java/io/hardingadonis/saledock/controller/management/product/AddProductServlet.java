package io.hardingadonis.saledock.controller.management.product;

import io.hardingadonis.saledock.model.*;
import io.hardingadonis.saledock.utils.*;
import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.*;
import java.util.*;

@WebServlet(name = "AddProductServlet", urlPatterns = {"/add-product"})
public class AddProductServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");

        request.setAttribute("page", "product");

        List<Category> cat = Singleton.categoryDAO.getAll();

        request.setAttribute("categories", cat);
        System.out.println(cat);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/view/jsp/management/product/add-product.jsp");
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String codePro = request.getParameter("codeP");
        String namePro = request.getParameter("nameP");

        int catPro = Integer.parseInt(request.getParameter("categoryP"));
        Optional<Category> cat = Singleton.categoryDAO.getByID(catPro);

        double pricePro = Double.parseDouble(request.getParameter("priceP"));
        String desPro = request.getParameter("descriptionP");

//        try {
//            List<FileItem> items = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);
//            for (FileItem item : items) {
//                if (!item.isFormField() && item.getFieldName().equals("imageUpload")) {
//                    // item is the file (and not a field)
//                    InputStream fileContent = item.getInputStream();
//                    // assuming you have a connection (conn) to your database
//                    PreparedStatement stmt = conn.prepareStatement("INSERT INTO images (content) VALUES (?)");
//                    stmt.setBlob(1, fileContent);
//                    stmt.executeUpdate();
//                    break; // we only process one image, so break the loop after the first file
//                }
//            }
//        } catch (Exception e) {
//            throw new ServletException("Cannot parse multipart request.", e);
//        }
        
        Product p = new Product();
        p.setCode(codePro.toUpperCase());
        p.setName(namePro);
        p.setCategory(cat.get());
        p.setPrice(pricePro);
        p.setDescription(desPro);
        Singleton.productDAO.save(p);

        response.sendRedirect("product");
    }

}
