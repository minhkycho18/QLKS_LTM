package model.service;

import java.util.List;

import model.bean.Room;

public interface IRoomService {

	List<Room> findAllByAdminId(int id);
	
	List<Room> searchRoom(String name);

	void deleteRooms(String[] listIdRooms);

	Room findOneById(String idRoom);

	void updateRoom(String idRoom, String nameRoom, int numOfBed, double price, String description);
	
}
