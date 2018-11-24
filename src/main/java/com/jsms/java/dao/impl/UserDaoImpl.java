package com.jsms.java.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.jsms.java.constants.JsfsLiterals;
import com.jsms.java.constants.JsfsTables;
import com.jsms.java.dao.UserDao;
import com.jsms.java.model.Agent;
import com.jsms.java.model.Customer;
import com.jsms.java.model.Employee;
import com.jsms.java.model.User;
import com.jsms.java.util.RestfulResponseHelper;
import com.jsms.java.util.SMSHelper;

@Repository(value="userDao")
public class UserDaoImpl implements UserDao{

	@Autowired
	Environment env;
	
	@Autowired
	private RestfulResponseHelper restFulHelper;
	
	 @Autowired
	 private JdbcTemplate jdbcTemplate;
	
	 @Autowired
	 private SMSHelper smsHelper;
	 
	 public JdbcTemplate getJdbcTemplate() {
	        return jdbcTemplate;
	 }

	@Override
	public User findUserByEmailId(User user) {
		String sql="";
		int userType=0;
		User resultUser=null;
		
		/*if(user.getUserType() == 1){
			userType=1;
			sql = "SELECT * FROM USER WHERE userId = ? and password = ?";	
		}else if(user.getUserType() == 2){
			userType=2;
			sql = "SELECT * FROM employee_details WHERE empCode = ? and password = ?";
		}else if(user.getUserType() == 3){
			userType=3;
			sql = "SELECT * FROM agent_personal_details WHERE agentCode = ? and password = ?";
		}else if(user.getUserType() == 4){
			userType=4;
			sql = "SELECT * FROM customer_personal_details WHERE customerCode = ? and password = ?";
		}*/
		
		
		sql = "SELECT * FROM "+JsfsTables.USER+" WHERE userId = ? and password = ?";
		
		resultUser = (User)jdbcTemplate.queryForObject(sql,new Object[]{user.getUserId(),user.getPassword()},new BeanPropertyRowMapper<User>(User.class)); 
		resultUser.setCode(null);
		resultUser.setPassword(null);
		resultUser.setUserId(user.getUserId());
		//resultUser.setUserType(userType);
		resultUser.setStatus(JsfsLiterals.RESPONSE_SUCCESS);
		resultUser.setMessage(JsfsLiterals.LOGIN_SUCCESS);
		
		if(resultUser.getUserType() == 1){
			resultUser.setProfilePic(JsfsLiterals.BASE_URL+""+resultUser.getProfilePic());
		}else if(resultUser.getUserType() == 2){
			resultUser.setProfilePic(JsfsLiterals.BASE_URL+"employee/"+resultUser.getProfilePic());
		}else if(resultUser.getUserType() == 3){
			resultUser.setProfilePic(JsfsLiterals.BASE_URL+"agent/"+resultUser.getProfilePic());
		}else if(resultUser.getUserType() == 3){
			resultUser.setProfilePic(JsfsLiterals.BASE_URL+"customer/"+resultUser.getProfilePic());
		}
		
		
		resultUser.setSessionId("sdfsdfsd2343432sfdfsdf3423");
		return resultUser;
	}
	
	@Override
	public User changePassword(User user) {
		String updateSql="";
		int userType=0;
		//User resultUser= user;
		
		updateSql = "UPDATE "+JsfsTables.USER+" SET password = ? WHERE userId = ? and password = ?";
		
/*		if(user.getUserType() == 1){
			userType=1;
			updateSql = "UPDATE "+JsfsTables.USER+" SET password = ? WHERE userId = ? and password = ?";	
		}else if(user.getUserType() == 2){
			userType=2;
			updateSql = "UPDATE "+JsfsTables.EMPLOYEE_DETAILS+" SET password = ? WHERE empCode = ? and password = ?";
		}else if(user.getUserType() == 3){
			userType=3;
			updateSql = "UPDATE "+JsfsTables.AGENT_PERSONAL_DETAILS+" SET password = ? WHERE agentCode = ? and password = ?";
		}else if(user.getUserType() == 4){
			userType=4;
			updateSql = "UPDATE "+JsfsTables.CUSTOMER_PERSONAL_DETAILS+" SET password = ? WHERE customerCode = ? and password = ?";
		}*/
		int res = jdbcTemplate.update(updateSql,new Object[]{user.getPassword(),user.getUserId(),user.getOldPassword()}); 
		user.setCode(null);
		user.setPassword(null);
		user.setUserType(userType);
		
		if(res == 1){
			user.setStatus(JsfsLiterals.RESPONSE_SUCCESS);
			user.setMessage(JsfsLiterals.CHANGE_PASSWORD_SUCCESS);
			user.setSessionId("sdfsdfsd2343432sfdfsdf3423");
		}else{
			user.setStatus(JsfsLiterals.RESPONSE_FAIL);
			user.setMessage(JsfsLiterals.CHANGE_PASSWORD_FAIL);
		}
		
		return user;
	}

	@Override
	public User findByAccountNo(String accountNo) {
		String query = "select * from "+JsfsTables.USER+" where userId = "+accountNo;
		User user = jdbcTemplate.queryForObject(query,new BeanPropertyRowMapper<User>(User.class));
		return user;
	}

	@Override
	public String findMobileNoById(String accountNo,int userType) {
		
		String query="";
		String mobileNo="";
		if(userType == 1){
			query = "select * from "+JsfsTables.USER+" WHERE userId = "+accountNo;	
			User user = jdbcTemplate.queryForObject(query,new BeanPropertyRowMapper<User>(User.class));
			mobileNo =  user.getPassword();
		}else if(userType == 2){
			query = "select * from "+JsfsTables.EMPLOYEE_DETAILS+" WHERE empCode = "+accountNo;
			Employee employee = jdbcTemplate.queryForObject(query,new BeanPropertyRowMapper<Employee>(Employee.class));
			mobileNo =  employee.getMobileNo();
		}else if(userType == 3){
			query = "select * from "+JsfsTables.AGENT_PERSONAL_DETAILS+" WHERE agentCode = "+accountNo;
			Agent agent = jdbcTemplate.queryForObject(query,new BeanPropertyRowMapper<Agent>(Agent.class));
			mobileNo =  agent.getMobileNo();
		}else if(userType == 4){
			query = "select * from "+JsfsTables.CUSTOMER_PERSONAL_DETAILS+" WHERE customerCode = "+accountNo;
			Customer customer = jdbcTemplate.queryForObject(query,new BeanPropertyRowMapper<Customer>(Customer.class));
			mobileNo =  customer.getMobileNo();
		}
		return mobileNo;
	}

	@Override
	public String sendSMS(String mobileNo,String accountNo,String password) {
		smsHelper.sendSMSToForgotUser(mobileNo, accountNo, password);
		return "Password sent to registered mobile number successfully";//env.getProperty("fp.success");
	}
}
