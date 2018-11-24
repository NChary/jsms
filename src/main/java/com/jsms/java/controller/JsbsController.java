package com.jsms.java.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jsms.java.model.JsbsCustomer;
import com.jsms.java.model.Receipt;
import com.jsms.java.model.RestfulResponse;
import com.jsms.java.service.JsbsService;

@RestController
public class JsbsController {
	
	@Autowired
	private JsbsService jsbsService;
	
	
    @RequestMapping(value = "/getjsbscustomer",  method = RequestMethod.GET,headers="Accept=application/json")
    public List<JsbsCustomer> getJsbsCustomers() {
    	  List<JsbsCustomer> jsbsUsers = null;
          try {
				  jsbsUsers = jsbsService.getAllJsbsCustomers();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
          return jsbsUsers;
    }

    @RequestMapping(value = "/getjsbsreceipts",  method = RequestMethod.GET,headers="Accept=application/json")
    public List<Receipt> getJsbsReceipts() {
    	  List<Receipt> jsbsReceipts = null;
          try {
        	  jsbsReceipts = jsbsService.getAllJsbsReceipts();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
          return jsbsReceipts;
    }
    
    
    @RequestMapping(value = "/createjsbsuser", method = RequestMethod.POST,headers="Accept=application/json")
	public RestfulResponse createJsbsUser(@RequestBody JsbsCustomer jsbsCustomer)
	{
		RestfulResponse restFullResponse=null;
		try{
			restFullResponse = jsbsService.saveUser(jsbsCustomer);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return restFullResponse;
	}
 
    
    
	
}
