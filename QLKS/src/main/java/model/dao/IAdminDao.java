package model.dao;

import model.bean.Admin;

public interface IAdminDao  {
	Admin findOneByUsernameAndPassword(String username, String password);

	Long saveAccount(String username, String password, String email);

	boolean checkExistAccount(String username, String email);

	Admin findOneById(Long id);
}
