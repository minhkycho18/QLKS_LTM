package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.Room;
import model.service.IRoomService;
import model.service.impl.RoomService;

@WebServlet("/HandleSearchServlet")
public class HandleSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private IRoomService roomService;

	public HandleSearchServlet() {
		roomService = new RoomService();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println(1);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		String searchValue = request.getParameter("search");
		List<Room> searchRooms = roomService.searchRoom(searchValue);
		request.setAttribute("rooms", searchRooms);
		request.getRequestDispatcher("searchResult.jsp").forward(request, response);
	}

}