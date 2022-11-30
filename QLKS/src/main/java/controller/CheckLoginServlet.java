package controller;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

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

@WebServlet("/CheckLoginServlet")
public class CheckLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IAdminService adminService;
	private IRoomService roomService;

	public CheckLoginServlet() {
		adminService = new AdminService();
		roomService = new RoomService();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Admin admin = null;
		String func = request.getParameter("func");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		// get admin
		if ((Admin) request.getSession().getAttribute("account") != null) {
			admin = (Admin) request.getSession().getAttribute("account");
		} else {
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			admin = adminService.getAccount(username, password);
		}
		// redirect
		if (admin != null) {
			List<Room> adminRooms = roomService.findAllByAdminId(admin.getId());

			request.setAttribute("rooms", adminRooms);
			request.getSession().setAttribute("account", admin);
			request.getRequestDispatcher("dashboard.jsp").forward(request, response);
		} else {
			String responseMsg = "Sai tài khoản hoặc mật khẩu";
			request.setAttribute("message", responseMsg);
			request.getRequestDispatcher("Login.jsp").forward(request, response);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
