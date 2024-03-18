package io.hardingadonis.saledock.controller.others.login;

import io.hardingadonis.saledock.model.*;
import io.hardingadonis.saledock.utils.*;
import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.*;
import java.io.*;
import java.util.*;

@WebServlet(name = "ForgotPasswordServlet", urlPatterns = { "/forgot-password" })
public class ForgotPasswordServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        request.getRequestDispatcher("/view/jsp/others/login/forgot-password.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");

        switch (action) {
            case "submitEmail" -> checkEmail(request, response);
            case "submitOtp" -> checkOtp(request, response);
            case "newPassword" -> newPassword(request, response);
            default -> response.sendRedirect("./login");
        }
    }

    private void checkEmail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("forgot-email").trim();

        if (email == null || email.isEmpty()) {
            request.setAttribute("message", "fail");
            request.getRequestDispatcher("/view/jsp/others/login/forgot-password.jsp").forward(request, response);
        } else {
            Optional<Employee> employee = Singleton.employeeDAO.getByEmail(email);

            if (employee.isPresent()) {
                request.setAttribute("message", "success");
                String newOtp = OtpUtil.generateRandomOTP();
                SendEmailUtil.sendGetOTPMessage(email, "Sale Dock - Quên mật khẩu?", newOtp);
                SessionUtil.getInstance().putValue(request, "otp", newOtp);
                SessionUtil.getInstance().putValue(request, "email", email);
                request.getRequestDispatcher("/view/jsp/others/login/otp.jsp").forward(request, response);
            } else {
                request.setAttribute("message", "emailNotExist");
                this.doGet(request, response);
            }
        }
    }

    private void checkOtp(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String otpInput = request.getParameter("otp-input").trim();
        String otpStored = (String) SessionUtil.getInstance().getValue(request, "otp");

        if (otpInput != null && otpStored != null && otpInput.equals(otpStored)) {
            SessionUtil.getInstance().removeValue(request, "otp");
            request.getRequestDispatcher("/view/jsp/others/login/new-password.jsp").forward(request, response);
        } else {
            request.setAttribute("message", "fail");
            request.getRequestDispatcher("/view/jsp/others/login/otp.jsp").forward(request, response);
        }
    }
    
    private void newPassword(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = (String) SessionUtil.getInstance().getValue(request, "email");
        
        String newPassword = request.getParameter("new-password");
        String confirmPassword = request.getParameter("confirm-password");
        
        if (newPassword == null || confirmPassword == null) {
            request.setAttribute("message", "fail");
        } 
        
        if (newPassword != null && confirmPassword != null) {
            if (newPassword.equals(confirmPassword)) {
                Employee employee = Singleton.employeeDAO.getByEmail(email).get();
                employee.setHashedPassword(Hash.MD5(newPassword));
                Singleton.employeeDAO.save(employee);
                SessionUtil.getInstance().removeValue(request, "email");
                response.sendRedirect("./login?message=success");
            } else {
                request.setAttribute("message", "notCorrect");
                request.getRequestDispatcher("/view/jsp/others/login/newPassword.jsp").forward(request, response);
            }
        } else {
            request.setAttribute("message", "fail");
            request.getRequestDispatcher("/view/jsp/others/login/newPassword.jsp").forward(request, response);
        }
    }
}
