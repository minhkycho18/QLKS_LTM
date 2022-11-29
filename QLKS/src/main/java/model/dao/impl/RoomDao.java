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

	
}
