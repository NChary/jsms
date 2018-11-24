package com.jsms.java.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jsms.java.model.CashBook;
import com.jsms.java.service.FinAccService;

@RestController
public class FinAccController {

	@Autowired
	private FinAccService finAccService;
	
	@RequestMapping(value = "/getcashbook", method=RequestMethod.GET,headers="Accept=application/json")
	public List<CashBook> getAllBranches(){
		List<CashBook> lstCashBook=null;
		try{
			lstCashBook = finAccService.getCashBook();
		}catch(Exception e){
			e.printStackTrace();
		}
		return lstCashBook;
	}
	
	
}
