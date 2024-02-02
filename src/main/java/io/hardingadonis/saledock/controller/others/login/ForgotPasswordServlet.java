package io.hardingadonis.saledock.controller.others.login;

import java.io.*;
import java.util.Optional;

import io.hardingadonis.saledock.model.Employee;
import io.hardingadonis.saledock.utils.Hash;
import io.hardingadonis.saledock.utils.Singleton;
import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.*;

@WebServlet(name = "ForgotPasswordServlet", urlPatterns = { "/forgot-password" })
public class ForgotPasswordServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/view/jsp/others/login/forgot-password.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		resetPassword(request, response);
	}

	private void resetPassword(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String code = request.getParameter("employee-code");
		String password = request.getParameter("password");

		if (code.isEmpty() || password.isEmpty()) {
			handleError(request, response);
			return;
		}

		Optional<Employee> employeeObj = Singleton.employeeDAO.getByCode(code.toUpperCase());

		if (employeeObj.isEmpty()) {
			response.sendRedirect(request.getContextPath() + "/forgot-password?message=notExists");
		}

		Employee actualEmployee = employeeObj.get();
		password = Hash.MD5(password);
		actualEmployee.setHashedPassword(password);
		Singleton.employeeDAO.save(actualEmployee);
		response.sendRedirect(request.getContextPath() + "/login?message=resetSuccess");
	}

	private void handleError(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("message", "fail");
		request.getRequestDispatcher("/view/jsp/others/login/forgot-password.jsp").forward(request, response);
	}
}
