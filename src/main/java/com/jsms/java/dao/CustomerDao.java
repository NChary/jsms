package com.jsms.java.dao;

import java.util.List;

import com.jsms.java.model.Customer;
import com.jsms.java.model.RestfulResponse;

public interface CustomerDao {
	RestfulResponse saveCustomer(Customer customer);
	int updateCardDetails(String cardNo,int cvv,String toDate);
	List<Customer> getAllCustomers();	
	int updateReceiptNoStatus(int receiptId);
	Customer getCustomerById(String customerId);
	List<Customer> getCustomersByAgentId(String agentCode);
	 List<Customer> getAssignCustomer();
	 boolean assignCardToCustomer(Customer customer);
	 boolean validateCardDetails(String cardNo, int cvvNo);
}
