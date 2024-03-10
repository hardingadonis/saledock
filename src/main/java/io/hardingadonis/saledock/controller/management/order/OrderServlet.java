package io.hardingadonis.saledock.controller.management.order;

import io.hardingadonis.saledock.model.*;
import io.hardingadonis.saledock.utils.*;
import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.*;
import java.io.*;
import java.util.*;

@WebServlet(name = "OrderServlet", urlPatterns = {"/order"})
public class OrderServlet extends HttpServlet {

    final static int LIMIT = 10;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");

        List<Order> orders = Singleton.orderDAO.getAll();
        int count = Singleton.orderDAO.count();

        String pageNumParam = request.getParameter("page");
        int pageNum = 0;

        if (pageNumParam == null || pageNumParam.isEmpty()) {
            pageNum = 1;
        } else {
            try {
                pageNum = Integer.parseInt(pageNumParam);
            } catch (NumberFormatException e) {
                response.sendRedirect("./error-404");
                return;
            }
        }

        if (pageNum < 0) {
            response.sendRedirect("./error-404");
            return;
        }

        int offset = pageNum;

        if (offset == 0) {
            pageNum = 1;
        } else {
            offset = (offset - 1) * LIMIT;
        }

        List<Order> orderPaging = Singleton.orderDAO.pagination(offset, LIMIT);
        int total = Singleton.orderDAO.totalPages(LIMIT);

        request.setAttribute("numOfOrder", count);
        request.setAttribute("currentPage", pageNum);
        request.setAttribute("totalPage", total);
        request.setAttribute("limit", LIMIT);
        request.setAttribute("orders", orderPaging);
        request.setAttribute("page", "order");

        request.getRequestDispatcher("/view/jsp/management/order/order.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }
}
