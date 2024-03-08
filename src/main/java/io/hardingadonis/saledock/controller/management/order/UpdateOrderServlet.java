package io.hardingadonis.saledock.controller.management.order;

import io.hardingadonis.saledock.model.*;
import io.hardingadonis.saledock.utils.*;
import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.*;
import java.io.*;
import java.util.Optional;

@WebServlet(name = "UpdateOrderServlet", urlPatterns = {"/update-order"})
public class UpdateOrderServlet extends HttpServlet {

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

            request.getRequestDispatcher("/view/jsp/management/order/update-order.jsp").forward(request, response);
        } else {
            response.sendRedirect(request.getContextPath() + "/order");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String ID = request.getParameter("id");
        Order order = Singleton.orderDAO.getByID(Integer.valueOf(ID)).orElse(null);
        

        String status = request.getParameter("status");
        String note = request.getParameter("note");

        if (status != null && !status.equals(order.getStatus())) {

            order.setStatus(Order.Status.valueOf(status));
            
        } 
        if(!note.trim().isEmpty()){
            order.setNote(note.trim());
        }
        Singleton.orderDAO.save(order);

            response.sendRedirect(request.getContextPath() + "/order-detail?id=" + ID);
        
//        else {
//            response.sendRedirect(request.getContextPath() + "/order-detail?id=" + ID);
//            return;
//        }

    }

}
