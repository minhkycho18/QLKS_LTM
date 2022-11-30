package model.service;

import java.util.List;

import model.bean.Room;

public interface IRoomService {

	List<Room> findAllByAdminId(int id);

	void deleteRooms(String[] listIdRooms);

}
