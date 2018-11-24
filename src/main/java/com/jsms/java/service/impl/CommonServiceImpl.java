package com.jsms.java.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsms.java.dao.CommonDao;
import com.jsms.java.model.ErrorLog;
import com.jsms.java.service.CommonService;

@Service(value="commonService")
public class CommonServiceImpl implements CommonService{

	@Autowired
	private CommonDao commonDao;
	
	@Override
	public void saveErrorLog(ErrorLog errorLog) {
		commonDao.saveErrorLog(errorLog);
	}
}
