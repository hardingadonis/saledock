package io.hardingadonis.saledock.controller.others.download;

import io.hardingadonis.saledock.utils.*;
import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.*;

import java.io.*;

@WebServlet(name = "DownloadServlet", urlPatterns = {"/download"})
public class DownloadServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");

        var type = request.getParameter("type");

        var path = "";

        switch (type) {
            case "customer": {
                path = ExcelUtil.generateCustomersExcel(getServletContext().getRealPath("/"));
                break;
            }

            case "product": {
                path = ExcelUtil.generateProductsExcel(getServletContext().getRealPath("/"));
                break;
            }

            case "order": {
                Integer ID = Integer.parseInt(request.getParameter("id"));

                path = ExcelUtil.generateOrderDetailExcel(getServletContext().getRealPath("/"), ID);
                break;
            }

            default: {
                response.sendError(404);
                return;
            }
        }

        var file = new File(path);

        response.setContentType("application/octet-stream");
        response.setContentLength((int) file.length());
        response.setHeader("Content-Disposition", "attachment; filename=" + file.getName());

        try (var fileInputStream = new FileInputStream(file)) {
            var out = response.getOutputStream();
            var buffer = new byte[4096];
            int bytesRead;

            while ((bytesRead = fileInputStream.read(buffer)) != -1) {
                out.write(buffer, 0, bytesRead);
            }
        } catch (Exception ex) {
            response.sendError(404);
            return;
        }
    }
}
