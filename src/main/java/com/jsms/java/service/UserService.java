package com.jsms.java.service;

import java.util.List;

import com.jsms.java.model.User;



public interface UserService {
	
	User findById(long id);

	User findByUser(User user);
	
	User changePassword(User user);
	
	User findByName(String name);
	
	void saveUser(User user);
	
	void updateUser(User user);
	
	void deleteUserById(long id);

	List<User> findAllUsers(); 
	
	void deleteAllUsers();
	
	public boolean isUserExist(User user);
	
	String forgotPassword(String accountNo);
}
