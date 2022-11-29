package model.dao;

import java.util.List;

import mapper.AdminMapper;
import model.bean.Admin;

public class AdminDao extends AbstractDao<Admin> implements IAdminDao {

	@Override
	public Admin findOneByUsernameAndPassword(String username, String password) {
		String sql = "SELECT * "
				   + "FROM admin "
				   + "WHERE username = ? "
				   + "AND password = ? ";
		List<Admin> admins = query(sql, new AdminMapper(), username,password);
		return admins.isEmpty() ? null : admins.get(0);
	}

	
}
