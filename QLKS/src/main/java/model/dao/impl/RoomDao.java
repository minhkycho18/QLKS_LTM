package model.dao.impl;

import java.util.List;

import mapper.AdminMapper;
import mapper.RoomMapper;
import model.bean.Admin;
import model.bean.Room;
import model.dao.IRoomDao;

public class RoomDao extends AbstractDao<Room> implements IRoomDao {

	@Override
	public List<Room> findAllByAdminId(int id) {
		String sql =  "SELECT * "
					+ "FROM room "
					+ "WHERE admin_id = ?";
		return query(sql, new RoomMapper(), id);
	}

	@Override
	public void deleteRooms(String roomsDelete) {
		String sql =  "DELETE "
					+ "FROM room "
					+ "WHERE id_room IN ( " + roomsDelete + " ) ";
		update(sql, roomsDelete);
		
	}

	@Override
	public Room findOneById(String idRoom) {
		String sql = "SELECT * "
					+ "FROM room "
					+ "WHERE id_room = ? ";
		return query(sql, new RoomMapper(), idRoom).get(0);
	}

	@Override
	public void updateRoom(String idRoom, String nameRoom, int numOfBed, double price, String description) {
		String sql = "UPDATE room "
					+"SET nameroom = ? , num_bed = ? , description = ? , price = ? "
					+"WHERE id_room = ? ";
		update(sql, nameRoom, numOfBed, description, price, idRoom);
		
		
	}

	@Override
	public List<Room> searchRoom(String name) {
		String sql =  "SELECT * "
				+ "FROM room "
				+ "WHERE nameroom LIKE '%?%'";
	return query(sql, new RoomMapper(), name);
	}



	
}
