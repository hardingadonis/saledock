package io.hardingadonis.saledock.controller.management.order;

import io.hardingadonis.saledock.model.*;
import io.hardingadonis.saledock.utils.Singleton;
import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.*;
import java.util.Optional;

@WebServlet(name = "OrderDetailServlet", urlPatterns = {"/order-detail"})
public class OrderDetailServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");

        request.setAttribute("page", "order");

        String id = request.getParameter("id");
        if (id == null) {
            response.sendError(404);
            return;
        }

        Integer id_order = Integer.parseInt(id);
        Optional<Order> order = Singleton.orderDAO.getByID(id_order);

        if (order.isPresent()) {
            var ord = order.get();
            request.setAttribute("ord", ord);

            request.getRequestDispatcher("/view/jsp/management/order/order-detail.jsp").forward(request, response);
        } else {
            response.sendRedirect(request.getContextPath() + "/order");
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }
}
