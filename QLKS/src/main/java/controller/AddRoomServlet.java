package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.service.IRoomService;
import model.service.impl.RoomService;

@WebServlet("/AddRoomServlet")
public class AddRoomServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;

	private IRoomService roomService;

	public AddRoomServlet() {
		roomService = new RoomService();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.sendRedirect("AddRoom.jsp");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		String idRoom = request.getParameter("ID");
		String nameRoom = request.getParameter("nameroom");
		int numOfBed = Integer.parseInt(request.getParameter("numofbed"));
		double price = Double.parseDouble(request.getParameter("price"));
		String description = request.getParameter("description");
		if(!roomService.isExistIdRoom(idRoom)) {
			roomService.addRoom(idRoom, nameRoom, numOfBed, description, price);
			response.sendRedirect("DashboardServlet?func=get");
		} else {
			String respMsg = "Duplicated room ID!";
			request.setAttribute("message", respMsg);
			request.getRequestDispatcher("AddRoom.jsp").forward(request, response);
		}
		
	}
}