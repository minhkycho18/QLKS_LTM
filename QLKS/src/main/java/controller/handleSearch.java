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

/**
 * Servlet implementation class handleSearch
 */
@WebServlet("/handleSearch")
public class handleSearch extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */	private IRoomService roomService;
    public handleSearch() {
    	roomService = new RoomService();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		String query = request.getParameter("search");
		System.out.println(query);

		roomService.searchRoom(query);
		List<Room> searchRooms = roomService.searchRoom(query);
		request.setAttribute("rooms", searchRooms);
		response.sendRedirect("DashboardServlet?func=get");
		System.out.println("request");
		doGet(request, response);
		
	}

}
