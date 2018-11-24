package com.jsms.java.dao;

import com.jsms.java.model.ErrorLog;

public interface CommonDao {
	void saveErrorLog(ErrorLog errorLog);
	void saveSmsInfoLog(String mobileNo,String message);
}
