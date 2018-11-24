package com.jsms.java.dao;

import java.util.List;

import com.jsms.java.model.JsbsCustomer;
import com.jsms.java.model.Receipt;
import com.jsms.java.model.RestfulResponse;

public interface JsbsDao {
	RestfulResponse saveUser(JsbsCustomer jsbsCustomer);
	List<Receipt> getAllJsbsReceipts();
	List<JsbsCustomer> getAllJsbsCustomers();
}
