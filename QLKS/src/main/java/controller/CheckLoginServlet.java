package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.Admin;
import model.service.IAdminService;
import model.service.impl.AdminService;

@WebServlet("/CheckLoginServlet")
public class CheckLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IAdminService adminService;
	public CheckLoginServlet() {
		adminService = new AdminService();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if ((Admin) request.getSession().getAttribute("account") != null) {
			response.sendRedirect("dashboard.jsp");
		}else {			
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			Admin a = adminService.getAccount(username,password);
			if (a!=null) {
				request.getSession().setAttribute("account", a);
				response.sendRedirect("dashboard.jsp");
			} else {
				response.sendRedirect("Login.jsp");
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
