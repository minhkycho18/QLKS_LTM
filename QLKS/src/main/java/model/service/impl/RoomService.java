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

	@Override
	public void deleteRooms(String[] listIdRooms) {
		StringBuilder sb = new StringBuilder();
		for(String id : listIdRooms)
		{
			sb.append("'" + id + "'");
			if(id.equals(listIdRooms[listIdRooms.length-1]))
			{
				continue;
			}
			sb.append(",");
		}
		roomDao.deleteRooms(sb.toString());
		
	}

	@Override
	public Room findOneById(String idRoom) {
		return roomDao.findOneById(idRoom);
	}

	@Override
	public void updateRoom(String idRoom, String nameRoom, int numOfBed, double price, String description) {
		roomDao.updateRoom(idRoom, nameRoom, numOfBed, price, description);
		
	}

	@Override
	public List<Room> searchRoom(String name) {
		return roomDao.searchRoom(name);
	}


}
