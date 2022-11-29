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
import model.service.IRoomService;
import model.service.impl.RoomService;

@WebServlet("/DashboardServlet")
public class DashboardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private IRoomService roomService;
	public DashboardServlet() {
		roomService = new RoomService();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Admin admin = (Admin)request.getSession().getAttribute("account");
		if (admin != null) {
			List<Room> adminRooms = roomService.findAllByAdminId(admin.getId());
			request.setAttribute("rooms", adminRooms);
			request.getSession().setAttribute("account", admin);
			request.getRequestDispatcher("dashboard.jsp").forward(request, response);
		} else {
			response.sendRedirect("Login.jsp");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}