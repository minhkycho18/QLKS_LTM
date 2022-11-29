package model.dao;

import model.bean.Admin;

public interface IAdminDao  {
	Admin findOneByUsernameAndPassword(String username, String password);
}
