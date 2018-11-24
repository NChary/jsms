package com.jsms.java.service;

import java.util.List;

import com.jsms.java.model.JsbsCustomer;
import com.jsms.java.model.Receipt;
import com.jsms.java.model.RestfulResponse;

public interface JsbsService {
	List<JsbsCustomer> getAllJsbsCustomers();
	List<Receipt> getAllJsbsReceipts();
	RestfulResponse saveUser(JsbsCustomer jsbsCustomer);
}
