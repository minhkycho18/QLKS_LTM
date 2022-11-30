package model.dao;

import java.util.List;

import model.bean.Admin;
import model.bean.Room;

public interface IRoomDao extends genericDao<Room> {

	List<Room> findAllByAdminId(int id);

	void deleteRooms(String roomsDelete);

	
	
}
