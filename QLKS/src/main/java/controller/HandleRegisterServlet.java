package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.Admin;
import model.bean.Room;
import model.service.IAdminService;
import model.service.IRoomService;
import model.service.impl.AdminService;
import model.service.impl.RoomService;

@WebServlet("/HandleRegisterServlet")
public class HandleRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private IRoomService roomService;
	private IAdminService adminService;
	
	public HandleRegisterServlet() {
		roomService = new RoomService();
		adminService = new AdminService();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		Long id = adminService.saveAccount(username,password,email);
		if (id == null)
		{
			String responseMsg = "Username or Email already exist";
			request.setAttribute("message", responseMsg);
			request.getRequestDispatcher("register.jsp").forward(request, response);
		} else {
			Admin admin = adminService.findOneById(id);
			request.getSession().setAttribute("account", admin);
			response.sendRedirect("DashboardServlet?func=get");
		}
	}

}
