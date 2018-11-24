package com.jsms.java.service;

import java.util.List;

import com.jsms.java.model.PaymentType;
import com.jsms.java.model.ProductSubCat;
import com.jsms.java.model.Receipt;
import com.jsms.java.model.ReceiptType;
import com.jsms.java.model.RestfulResponse;

public interface ReceiptService {
	RestfulResponse createReceipt(Receipt receipt);
	List<Receipt> getAllReceipts();
	List<ReceiptType> getAllReceiptTypes();
	List<PaymentType> getAllPaymentTypes();
	List<Receipt> getReceiptIds();
	List<ProductSubCat> getAllProductSub();
	List<Receipt> getAllJsbsReceipt(String agentCode);
}
