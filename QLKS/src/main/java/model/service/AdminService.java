package model.service;

import model.bean.Admin;
import model.dao.AdminDao;
import model.dao.IAdminDao;

public class AdminService implements IAdminService {
	
	private IAdminDao adminDao;
	
	public AdminService() {
		adminDao = new AdminDao();
	}
	@Override
	public Admin getAccount(String username, String password) {
		return adminDao.findOneByUsernameAndPassword(username,password);
	}
	
}
