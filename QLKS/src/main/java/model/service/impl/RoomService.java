package model.service.impl;

import java.util.ArrayList;
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
	public void addRoom(String idRoom, String nameRoom, int numOfBed, String description, double price) {
		roomDao.addRoom(idRoom, nameRoom, numOfBed, description, price);
	}

	@Override
	public boolean isExistIdRoom(String idRoom) {
		List<String> ids = new ArrayList<>();
		List<Room> rooms = roomDao.getAllRooms();
		for(Room room : rooms) {
			ids.add(room.getId());
		}
		if(ids.contains(idRoom)) {
			return true;
		}
		return false;
	}


}
