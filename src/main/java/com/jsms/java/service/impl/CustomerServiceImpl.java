package com.jsms.java.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsms.java.constants.JsfsLiterals;
import com.jsms.java.dao.CustomerDao;
import com.jsms.java.model.Customer;
import com.jsms.java.model.RestfulResponse;
import com.jsms.java.service.CustomerService;

@Service(value="customerservice")
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	private CustomerDao customerDao;
	
	 
	@Override
	public RestfulResponse saveCustomer(Customer customer) {
		return customerDao.saveCustomer(customer);
	}


	@Override
	public List<Customer> getAllCustomers() {
		return customerDao.getAllCustomers();
	}


	@Override
	public String validCardDetails(String cardNo, int cvvNo) {
		return null;
		//return customerDao.validateCardDetails(cardNo, cvvNo);
	}


	@Override
	public Customer getCustomerById(String customerId) {
		return customerDao.getCustomerById(customerId);
	}


	@Override
	public List<Customer> getCustomersByAgentId(String agentCode) {
		return customerDao.getCustomersByAgentId(agentCode);
	}


	@Override
	public List<Customer> getAssignCustomer() {
		return customerDao.getAssignCustomer();
	}


	@Override
	public RestfulResponse assignCardToCustomer(Customer customer) {
		
		RestfulResponse restfulResponse = new RestfulResponse();
		boolean isCardValid = customerDao.validateCardDetails(customer.getCardNumber(), customer.getCvvNumber());
		if(isCardValid){
			boolean res = customerDao.assignCardToCustomer(customer);
			restfulResponse.setMessage("Assign Card successfully to Customer");
			restfulResponse.setStatus(JsfsLiterals.RESPONSE_SUCCESS);
		}else{
			restfulResponse.setMessage("Invalid Card Details");
		}
		
		return restfulResponse;
	}

}
