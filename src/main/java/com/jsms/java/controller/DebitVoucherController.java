package com.jsms.java.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jsms.java.model.DebitVoucher;
import com.jsms.java.model.DebitVoucherTypes;
import com.jsms.java.model.RestfulResponse;
import com.jsms.java.service.DebitVoucherService;

@RestController
public class DebitVoucherController {
	
	@Autowired
	private DebitVoucherService debitVoucherService;
	 
	@RequestMapping(value = "/createdv", method = RequestMethod.POST,headers="Accept=application/json")
	public RestfulResponse createDebitVoucher(@RequestBody DebitVoucher debitVoucher)
	{
		RestfulResponse restFullResponse=null;
		try{
			restFullResponse = debitVoucherService.createDebitVoucher(debitVoucher);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return restFullResponse;
	}

	@RequestMapping(value = "/getexptypes", method = RequestMethod.GET,headers="Accept=application/json")
	public List<DebitVoucherTypes> getAllExpenditureTypes()
	{
		List<DebitVoucherTypes> lstAgents=null;
		try{
			lstAgents = debitVoucherService.getAllExpenditureTypes();
		}catch(Exception e){
			e.printStackTrace();
		}
		return lstAgents;
	}
	
	
	@RequestMapping(value = "/getalldv", method = RequestMethod.GET,headers="Accept=application/json")
	public List<DebitVoucher> getAllDebVlouchers()
	{
		List<DebitVoucher> lstDebitVouchers=null;
		try{
			lstDebitVouchers = debitVoucherService.getAllDebitVouchers();
		}catch(Exception e){
			e.printStackTrace();
		}
		return lstDebitVouchers;
	}
	
}
