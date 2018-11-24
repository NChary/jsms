package com.jsms.java.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsms.java.dao.DebitVoucherDao;
import com.jsms.java.model.DebitVoucher;
import com.jsms.java.model.DebitVoucherTypes;
import com.jsms.java.model.RestfulResponse;
import com.jsms.java.service.DebitVoucherService;

@Service(value="dvService")
public class DebitVoucherServiceImpl implements DebitVoucherService{

	@Autowired
	private DebitVoucherDao debitVoucherDao;

	@Override
	public RestfulResponse createDebitVoucher(DebitVoucher debitVoucher) {
		return debitVoucherDao.createDebitVoucher(debitVoucher);
	}

	@Override
	public List<DebitVoucherTypes> getAllExpenditureTypes() {
		return debitVoucherDao.getAllExpenditureTypes();
	}

	@Override
	public List<DebitVoucher> getAllDebitVouchers() {
		return debitVoucherDao.getAllDebitVouchers();
	}
	
	 
	
}
