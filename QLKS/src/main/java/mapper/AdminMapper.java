package mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import model.bean.Admin;

public class AdminMapper implements IRowMapper<Admin> {
	@Override
	public Admin MappingRow(ResultSet rs) {
		Admin result = null;
		try {
			result = new Admin(rs.getInt("id"),rs.getString("username"),rs.getString("password"),
									 rs.getString("phone"),rs.getString("gmail"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}

}
