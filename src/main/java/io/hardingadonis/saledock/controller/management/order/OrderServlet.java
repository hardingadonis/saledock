package io.hardingadonis.saledock.controller.management.order;

import io.hardingadonis.saledock.model.*;
import io.hardingadonis.saledock.utils.*;
import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.*;
import java.io.*;
import java.util.*;
import java.util.stream.*;

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
        
        int pageNum = getInteger(request.getParameter("page"));
        int offset = pageNum;
        
        if (offset == -1){
            offset = 0;
            pageNum = 1;
        } else {
            offset = (offset - 1)*LIMIT;
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
    
    private static int getInteger(String parameter){
        if (parameter == null) {
            return -1;
        }
        try {
            return Integer.parseInt(parameter);
        } catch (NumberFormatException e) {
            return -1;
        }
    }
}
