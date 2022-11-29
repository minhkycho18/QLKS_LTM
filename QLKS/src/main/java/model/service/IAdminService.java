package model.service;

import model.bean.Admin;

public interface IAdminService {

	Admin getAccount(String username, String password);

}
