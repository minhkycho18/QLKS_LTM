package model.service;

import model.bean.Admin;

public interface IAdminService {

	Admin getAccount(String username, String password);

	Long saveAccount(String username, String password, String email);

	Admin findOneById(Long id);

}
