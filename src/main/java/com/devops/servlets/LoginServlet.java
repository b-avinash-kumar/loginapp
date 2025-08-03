package com.devops.servlets;

import java.io.IOException;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import com.devops.service.UserService;

public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		String uname = request.getParameter("uname");
		String upwd = request.getParameter("upwd");
		RequestDispatcher reqDispatcher = null;
		UserService userService = new UserService();
		String status = userService.checkLogin(uname, upwd);
		if (status.equals("success")) {
			reqDispatcher = request.getRequestDispatcher("success.html");
			reqDispatcher.forward(request, response);
		} else {
			reqDispatcher = request.getRequestDispatcher("failure.html");
			reqDispatcher.forward(request, response);
		}
	}
}
