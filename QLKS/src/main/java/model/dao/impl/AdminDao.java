package model.dao.impl;

import java.util.List;

import mapper.AdminMapper;
import model.bean.Admin;
import model.dao.IAdminDao;

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

	@Override
	public Long saveAccount(String username, String password, String email) {
		String sql = "INSERT INTO admin(username,password,email) values(?,?,?)";
		return insert(sql, username,password,email);
	}

	@Override
	public boolean checkExistAccount(String username, String email) {
		String sql = "SELECT * "
					+ "FROM admin "
					+ "WHERE username = ? OR email = ?";
		List<Admin> data = query(sql,new AdminMapper(), username, email);
		return data.isEmpty() ? true : false;
	}

	@Override
	public Admin findOneById(Long id) {
		String sql = "SELECT * "
					+ "FROM admin "
					+ "WHERE id = ?";
		List<Admin> admins = query(sql, new AdminMapper(), id);
		return admins.isEmpty() ? null : admins.get(0);
	}

	
}
