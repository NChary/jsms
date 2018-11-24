package com.jsms.java.service.impl;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.jsms.java.dao.UserDao;
import com.jsms.java.model.User;
import com.jsms.java.service.UserService;

@Service(value = "userService")
public class UserServiceImpl implements UserService{
	
	@Autowired
	Environment env;
	
	@Autowired
	private UserDao userDao;
	
	private static final AtomicLong counter = new AtomicLong();
	
	private static List<User> users;
	
	public List<User> findAllUsers() {
		return users;
	}
	
/*	public User findById(long id) {
		for(User user : users){
			if(user.getId() == id){
				return user;
			}
		}
		return null;
	}
	
	public User findByName(String name) {
		for(User user : users){
			if(user.getUsername().equalsIgnoreCase(name)){
				return user;
			}
		}
		return null;
	}
	
	public void saveUser(User user) {
		user.setId(counter.incrementAndGet());
		System.out.println("Environment Vari = "+env.getProperty("schema"));
		users.add(user);
	}

	public void updateUser(User user) {
		int index = users.indexOf(user);
		users.set(index, user);
	}

	public void deleteUserById(long id) {
		
		for (Iterator<User> iterator = users.iterator(); iterator.hasNext(); ) {
		    User user = iterator.next();
		    if (user.getId() == id) {
		        iterator.remove();
		    }
		}
	}

	public boolean isUserExist(User user) {
		return findByName(user.getUsername())!=null;
	}*/
	
	public void deleteAllUsers(){
		users.clear();
	}

	
	@Override
	public User findByUser(User user) {
		return userDao.findUserByEmailId(user);
	}

	@Override
	public User findById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveUser(User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateUser(User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteUserById(long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isUserExist(User user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public User changePassword(User user) {
		return userDao.changePassword(user);
	}

	@Override
	public String forgotPassword(String accountNo) { 
		String msg="";
		User user = userDao.findByAccountNo(accountNo);
		if(user.getUserType()>0){
			String mobileNo = userDao.findMobileNoById(accountNo, user.getUserType());
			if(mobileNo.length() == 10){
				msg = userDao.sendSMS(mobileNo,accountNo,user.getPassword());
			}else{
				msg = "Unable to find Mobile number for this Account No";//env.getProperty("fp.wrongaccountno");
			}
		}else{
			msg = "Please enter valid Account Number";//env.getProperty("fp.invalidaccountno");
		}
		return msg;
	}

}
