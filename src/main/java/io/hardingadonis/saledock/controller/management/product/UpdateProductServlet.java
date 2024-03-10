package io.hardingadonis.saledock.controller.management.product;

import io.hardingadonis.saledock.model.*;

import io.hardingadonis.saledock.utils.Singleton;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Optional;

@MultipartConfig()
@WebServlet(name = "UpdateProductServlet", urlPatterns = {"/update-product"})
public class UpdateProductServlet extends HttpServlet {

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
        String productName = request.getParameter("productName").trim();
        String productDescription = request.getParameter("productDescription");
        String productPrice = request.getParameter("price");

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

        Product product = Singleton.productDAO.getByID(idP).get();
        if (!productName.isEmpty()) {
            product.setName(productName);
        }
        if (!productPrice.isEmpty()) {
            product.setPrice(Double.parseDouble(productPrice));
        }
        if (imgURL != null) {
            product.setImageURL(imgURL);
        }
        if (!productDescription.isEmpty()) {
            product.setDescription(productDescription);
        }

        if (productDescription.trim().length() > 0) {
            product.setDescription(productDescription.trim());

        }

        Singleton.productDAO.save(product);

        response.sendRedirect("./product-detail?id=" + idP);
    }

}
