package com.persondemographic.service;


import java.util.List;

import com.persondemographic.model.User;

public interface UserService {
	
	public void createUser(User user);
	public List<User> listUsers();

}
