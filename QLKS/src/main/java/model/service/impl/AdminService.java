package model.service.impl;

import model.bean.Admin;
import model.dao.IAdminDao;
import model.dao.impl.AdminDao;
import model.service.IAdminService;

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
