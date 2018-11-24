package com.jsms.java.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsms.java.dao.FinAccDao;
import com.jsms.java.model.CashBook;
import com.jsms.java.service.FinAccService;

@Service(value="finService")
public class FinAccServiceImpl implements FinAccService{

	@Autowired
	private FinAccDao finAccDao;

	@Override
	public List<CashBook> getCashBook() {
		return finAccDao.getCashBook();
	}
	
	
	 
	
}
