package model.service.impl;

import java.util.List;

import model.bean.Room;
import model.dao.IRoomDao;
import model.dao.impl.RoomDao;
import model.service.IRoomService;

public class RoomService implements IRoomService {

	private IRoomDao roomDao;

	public RoomService() {
		roomDao = new RoomDao();
	}

	@Override
	public List<Room> findAllByAdminId(int id) {
		
		return roomDao.findAllByAdminId(id);
	}

}
