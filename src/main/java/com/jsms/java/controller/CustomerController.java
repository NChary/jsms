package com.jsms.java.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jsms.java.constants.JsfsLiterals;
import com.jsms.java.model.Customer;
import com.jsms.java.model.RestfulResponse;
import com.jsms.java.service.CustomerService;
import com.jsms.java.service.restexception.RestException;

@RestController
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	
	@RequestMapping(value = "/createcustomer", method = RequestMethod.POST,headers="Accept=application/json")
	public RestfulResponse createCustomer(@RequestBody Customer customer)
	{
		RestfulResponse restfullResponse=null;
		try{
			restfullResponse = customerService.saveCustomer(customer);
		}catch(Exception e){
			e.printStackTrace();
			restfullResponse = new RestfulResponse();
			restfullResponse.setCode(null);
			restfullResponse.setStatus(JsfsLiterals.RESPONSE_FAIL);
			restfullResponse.setMessage(e.toString());
		}
		
		return restfullResponse;
	}
	
	
	@RequestMapping(value = "/assigncard", method = RequestMethod.POST,headers="Accept=application/json")
	public RestfulResponse assignCardToCustomer(@RequestBody Customer customer)
	{
		RestfulResponse restfullResponse=new RestfulResponse();
		try{
			restfullResponse = customerService.assignCardToCustomer(customer);
		}catch(EmptyResultDataAccessException e){
			restfullResponse.setStatus(JsfsLiterals.RESPONSE_FAIL);
			restfullResponse.setMessage("Invalid Card Details");
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		return restfullResponse;
	}

	@RequestMapping(value = "/validatecard", method = RequestMethod.POST,headers="Accept=application/json")
	public String validCardDetails(@PathVariable String cardNo,@PathVariable int cvvNo)
	{
		String custResult="";
		try{
			custResult = customerService.validCardDetails(cardNo, cvvNo);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return custResult;
	}
	

	@RequestMapping(value = "/getallcustomers", method = RequestMethod.GET,headers="Accept=application/json")
	public List<Customer> getAllCustomers()
	{
		List<Customer> lstCustomers=null;
		try{
			lstCustomers = customerService.getAllCustomers();
		}catch(Exception e){
			e.printStackTrace();
		}
		return lstCustomers;
	}
	
	
	@RequestMapping(value = "/getassigncustomers", method = RequestMethod.GET,headers="Accept=application/json")
	public List<Customer> getAssignCustomers()
	{
		List<Customer> lstCustomers=null;
		try{
			lstCustomers = customerService.getAssignCustomer();
		}catch(Exception e){
			e.printStackTrace();
		}
		return lstCustomers;
	}
	
	
	@RequestMapping(value = "/getcustomerbyid/{id}", method = RequestMethod.GET,headers="Accept=application/json")
	public Customer getAgentById(@PathVariable String customerId)
	{
		Customer customer = null;
		try{
			customer = customerService.getCustomerById(customerId);
		}catch(Exception e){
			//e.printStackTrace();
			throw new RestException(JsfsLiterals.FETCH_CUSTOMER_CODE,JsfsLiterals.FETCH_CUSTOMER_DETAILS);
		}
		return customer;
	}
	
	@RequestMapping(value = "/getcustomersbyagentid/{id}", method = RequestMethod.GET,headers="Accept=application/json")
	public List<Customer> getCustomersByAgentId(@PathVariable String id)
	{
		List<Customer> customer = null;
		try{
			customer = customerService.getCustomersByAgentId(id);
		}catch(Exception e){
			//e.printStackTrace();
			throw new RestException(JsfsLiterals.FETCH_CUSTOMER_CODE,JsfsLiterals.FETCH_CUSTOMER_DETAILS);
		}
		return customer;
	}
	
	
	
}
