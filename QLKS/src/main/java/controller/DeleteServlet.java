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

@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private IRoomService roomService;

	public DeleteServlet() {
		roomService = new RoomService();
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String[] listIdRooms = request.getParameterValues("checkedRows");
		roomService.deleteRooms(listIdRooms);
		Admin admin = (Admin)request.getSession().getAttribute("account");
		List<Room> adminRooms = roomService.findAllByAdminId(admin.getId());
		request.setAttribute("rooms", adminRooms);
		request.getRequestDispatcher("DeleteRoom.jsp").forward(request, response);
	}

}
