package com.jsms.java.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsms.java.dao.JsbsDao;
import com.jsms.java.model.JsbsCustomer;
import com.jsms.java.model.Receipt;
import com.jsms.java.model.RestfulResponse;
import com.jsms.java.service.JsbsService;

@Service(value="jsbsService")
public class JsbsServiceImpl implements JsbsService{

	@Autowired
	private JsbsDao jsbsDao;

	@Override
	public List<JsbsCustomer> getAllJsbsCustomers() {
		return jsbsDao.getAllJsbsCustomers();
	}

	@Override
	public RestfulResponse saveUser(JsbsCustomer jsbsCustomer) {
		return jsbsDao.saveUser(jsbsCustomer);
	}

	@Override
	public List<Receipt> getAllJsbsReceipts() {
		return jsbsDao.getAllJsbsReceipts();
	}
	
	
}
