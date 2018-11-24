package com.jsms.java.dao;

import java.util.List;

import com.jsms.java.model.PaymentType;
import com.jsms.java.model.ProductSubCat;
import com.jsms.java.model.Receipt;
import com.jsms.java.model.ReceiptType;
import com.jsms.java.model.RestfulResponse;

public interface ReceiptDao {
	RestfulResponse createReceipt(Receipt receipt);
	List<Receipt> getAllReceiptDetails();
	List<PaymentType> getAllPaymentTypes();
	List<ReceiptType> getAllReceiptTypes();
	List<Receipt> getReceiptIds();
	List<ProductSubCat> getAllProductSub();
	List<Receipt> getAllJsbsReceipt(String agentCode);
}
