package io.hardingadonis.saledock.controller.management.product;

import io.hardingadonis.saledock.model.*;
import io.hardingadonis.saledock.utils.*;
import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.*;
import java.nio.file.*;
import static java.nio.file.Files.exists;
import java.util.*;

@WebServlet(name = "AddProductServlet", urlPatterns = {"/add-product"})
@MultipartConfig
public class AddProductServlet extends HttpServlet {

    public static final String UPLOAD_PRODUCT_IMG_DIRECTORY = "product_img";

    public static final int MEMORY_THRESHOLD = 1024 * 1024 * 3;
    public static final int MAX_FILE_SIZE = 1024 * 1024 * 3;
    public static final int MAX_REQUEST_SIZE = 1024 * 1024 * 5;

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

//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        request.setCharacterEncoding("UTF-8");
//        response.setContentType("text/html; charset=UTF-8");
//
//        String namePro = request.getParameter("nameP");
//        int catPro = Integer.parseInt(request.getParameter("categoryP"));
//        Optional<Category> cat = Singleton.categoryDAO.getByID(catPro);
//        double pricePro = Double.parseDouble(request.getParameter("priceP"));
//        String desPro = request.getParameter("descriptionP");
//
//        Part part = request.getPart("imageUpload");
//        String realPath = request.getServletContext().getRealPath("/product_img");
//        String fileName = Paths.get(part.getSubmittedFileName()).getFileName().toString();
//        String imgURL = "product_img/" + fileName;
//        if (!Files.exists(Paths.get(realPath))) {
//            Files.createDirectories(Paths.get(realPath));
//        }
//
//        part.write(realPath + "/" + fileName);
//
//        Product pro = new Product();
//        pro.setName(namePro);
//        pro.setCategory(cat.get());
//        pro.setPrice(pricePro);
//        pro.setImageURL(imgURL);
//        pro.setDescription(desPro);
//        Singleton.productDAO.save(pro);
//                    
//        response.sendRedirect("product");
//    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");

        String namePro = request.getParameter("nameP");
        int catPro = Integer.parseInt(request.getParameter("categoryP"));
        Optional<Category> cat = Singleton.categoryDAO.getByID(catPro);
        double pricePro = Double.parseDouble(request.getParameter("priceP"));
        String desPro = request.getParameter("descriptionP");

        Part part = request.getPart("imageUpload");
        String imgURL = null;
        if (part.getSize() > 0) {
            String realPath = request.getServletContext().getRealPath("/product_img");
            String fileName = Paths.get(part.getSubmittedFileName()).getFileName().toString();
            imgURL = "product_img/" + fileName;
            if (!Files.exists(Paths.get(realPath))) {
                Files.createDirectories(Paths.get(realPath));
            }

            part.write(realPath + "/" + fileName);
        }

        Product pro = new Product();
        pro.setName(namePro);
        pro.setCategory(cat.get());
        pro.setPrice(pricePro);
        pro.setImageURL(imgURL);
        pro.setDescription(desPro);
        Singleton.productDAO.save(pro);

        response.sendRedirect("product");
    }

}
