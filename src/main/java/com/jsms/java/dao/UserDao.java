package com.jsms.java.dao;

import com.jsms.java.model.User;

public interface UserDao {
	
	User findUserByEmailId(User user);
	
	User changePassword(User user);
	
	User findByAccountNo(String accountNo);
	
	String findMobileNoById(String accountNo,int userType);
	
	String sendSMS(String mobileNo,String accNo,String password);
}
