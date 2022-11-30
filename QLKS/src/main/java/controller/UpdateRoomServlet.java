package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.Room;
import model.service.IRoomService;
import model.service.impl.RoomService;

@WebServlet("/UpdateRoomServlet")
public class UpdateRoomServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private IRoomService roomService;
	public UpdateRoomServlet() {
		roomService = new RoomService();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		String idRoom = request.getParameter("id");
		Room room = roomService.findOneById(idRoom);
		request.setAttribute("room", room);
		request.getRequestDispatcher("UpdateForm.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		String idRoom = request.getParameter("idRoom");
		System.out.println(idRoom);
		String nameRoom = request.getParameter("nameRoom");
		int numOfBed = Integer.parseInt(request.getParameter("numBed"));
		double price = Double.parseDouble(request.getParameter("price"));
		String description = request.getParameter("description");
		roomService.updateRoom(idRoom, nameRoom, numOfBed, price, description);
		response.sendRedirect("DashboardServlet?func=get");
		
		
	}

}