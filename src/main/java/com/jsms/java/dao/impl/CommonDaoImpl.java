package com.jsms.java.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.jsms.java.constants.JsfsTables;
import com.jsms.java.dao.CommonDao;
import com.jsms.java.model.ErrorLog;

@Repository(value="commonDao")
public class CommonDaoImpl implements CommonDao{

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public void saveErrorLog(ErrorLog errorLog) {
		String sql = "insert into "+JsfsTables.JSMS_ERROR_LOG+"(className,methodName,requestData,employeeCode,agentCode,customerCode,exceptionText)values(?,?,?,?,?,?,?)";
		jdbcTemplate.update(sql,new Object[]{errorLog.getClassName(),errorLog.getMethodName(),errorLog.getRequestData(),errorLog.getEmployeeCode(),
				errorLog.getAgentCode(),errorLog.getCustomerCode(),errorLog.getExceptionText()});
	}

	@Override
	public void saveSmsInfoLog(String mobileNo, String message) {
		String sql = "insert into "+JsfsTables.SMS_INFO_LOG+"(mobileNo,message)values(?,?)";
		jdbcTemplate.update(sql,new Object[]{mobileNo,message});
	}
	
	
	
}
