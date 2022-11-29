package mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import model.bean.Room;

public class RoomMapper implements IRowMapper<Room> {
	@Override
	public Room MappingRow(ResultSet rs) {
		Room result = null;
		try {
			result = new Room(rs.getString("id_room"),rs.getString("nameroom"),rs.getInt("num_bed"),
									rs.getString("description"),rs.getDouble("price"),rs.getInt("admin_id"));
		} catch (SQLException e) {
		}
		
		return result;
	}
}
