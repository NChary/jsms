package com.jsms.java.service;

import java.util.List;

import com.jsms.java.model.Customer;
import com.jsms.java.model.RestfulResponse;

public interface CustomerService {
	RestfulResponse saveCustomer(Customer customer);
	 List<Customer> getAllCustomers();
	 String validCardDetails(String cardNo,int cvvNo);
	 Customer getCustomerById(String customerId);
	 List<Customer> getCustomersByAgentId(String agentCode);
	 List<Customer> getAssignCustomer();
	 RestfulResponse assignCardToCustomer(Customer customer);
}
