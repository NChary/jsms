package com.jsms.java.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsms.java.dao.ReceiptDao;
import com.jsms.java.model.PaymentType;
import com.jsms.java.model.ProductSubCat;
import com.jsms.java.model.Receipt;
import com.jsms.java.model.ReceiptType;
import com.jsms.java.model.RestfulResponse;
import com.jsms.java.service.ReceiptService;

@Service(value="receiptService")
public class ReceiptServiceImpl implements ReceiptService{

	@Autowired
	private ReceiptDao receiptDao;
	
	@Override
	public List<ReceiptType> getAllReceiptTypes() {
		return receiptDao.getAllReceiptTypes();
	}

	@Override
	public List<PaymentType> getAllPaymentTypes() {
		return receiptDao.getAllPaymentTypes();
	}

	@Override
	public RestfulResponse createReceipt(Receipt receipt) {
		return receiptDao.createReceipt(receipt);
	}

	@Override
	public List<Receipt> getAllReceipts() {
		return receiptDao.getAllReceiptDetails();
	}

	@Override
	public List<Receipt> getReceiptIds() {
		return receiptDao.getReceiptIds();
	}

	@Override
	public List<ProductSubCat> getAllProductSub() {
		return receiptDao.getAllProductSub();
	}

	@Override
	public List<Receipt> getAllJsbsReceipt(String agentCode) {
		return receiptDao.getAllJsbsReceipt(agentCode);
	}

}
