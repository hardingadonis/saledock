package io.hardingadonis.saledock.controller.others.login;

import io.hardingadonis.saledock.model.Employee;
import io.hardingadonis.saledock.utils.Hash;
import io.hardingadonis.saledock.utils.SessionUtil;
import io.hardingadonis.saledock.utils.Singleton;
import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.*;
import java.io.*;
import java.util.Optional;

@WebServlet(name = "LoginServlet", urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    request.getRequestDispatcher("/view/jsp/others/login/login.jsp")
        .forward(request, response);
  }

  @Override
  protected void doPost(HttpServletRequest request,
                        HttpServletResponse response)
      throws ServletException, IOException {

    request.setCharacterEncoding("UTF-8");
    signIn(request, response);
  }

  private void signIn(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    String code = request.getParameter("employee-code");
    String password = request.getParameter("password");

    if (code.isEmpty() || password.isEmpty()) {
      handleError(request, response);
      return;
    }

    password = Hash.MD5(password);

    Optional<Employee> employee =
        Singleton.employeeDAO.getByCode(code.toUpperCase());

    if (employee.isPresent() &&
        password.equals(employee.get().getHashedPassword())) {
      SessionUtil.getInstance().putValue(request, "employee", employee.get());
      response.sendRedirect(request.getContextPath() + "/dashboard");
    } else {
      response.sendRedirect(request.getContextPath() +
                            "/login?message=notCorrect");
    }
  }

  private void handleError(HttpServletRequest request,
                           HttpServletResponse response)
      throws ServletException, IOException {
    request.setAttribute("message", "fail");
    request.getRequestDispatcher("/view/jsp/others/login/login.jsp")
        .forward(request, response);
  }
}
