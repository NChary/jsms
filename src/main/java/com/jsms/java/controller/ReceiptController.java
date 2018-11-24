package com.jsms.java.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jsms.java.model.PaymentType;
import com.jsms.java.model.ProductSubCat;
import com.jsms.java.model.Receipt;
import com.jsms.java.model.ReceiptType;
import com.jsms.java.model.RestfulResponse;
import com.jsms.java.service.ReceiptService;
import com.jsms.java.service.restexception.RestException;

@RestController
public class ReceiptController {

	//private static final Logger logger = LoggerFactory.getLogger(RQAProjectController.class);
	
	
	@Autowired
	private ReceiptService receiptService;

	@RequestMapping(value = "/getreceipttypes", method = RequestMethod.GET,headers="Accept=application/json")
	public List<ReceiptType> getAllReceiptTyeps()
	{
		List<ReceiptType> receiptType = null;
		try{
			receiptType = receiptService.getAllReceiptTypes();
		}catch(Exception e){
			e.printStackTrace();
		}
		return receiptType;
	}

	
	@RequestMapping(value = "/getpaymenttypes", method = RequestMethod.GET,headers="Accept=application/json")
	public List<PaymentType> getAllPaymentTyeps()
	{
		List<PaymentType> paymentType = null;
		try{
			paymentType = receiptService.getAllPaymentTypes();
		}catch(Exception e){
			e.printStackTrace();
		}
		return paymentType;
	}

	@RequestMapping(value = "/createreceipt", method = RequestMethod.POST,headers="Accept=application/json")
	public RestfulResponse saveReceipt(@RequestBody Receipt receipt )
	{
		RestfulResponse restfulResponse = null;
		try{
			restfulResponse = receiptService.createReceipt(receipt);
		}catch(Exception e){
			e.printStackTrace();
			throw new RestException("test","test");
		}
		return restfulResponse;
	}
	
	@RequestMapping(value = "/getallreceipts", method = RequestMethod.GET,headers="Accept=application/json")
	public List<Receipt> getAllReceipts()
	{
		List<Receipt> lstreceipts = null;
		try{
			lstreceipts = receiptService.getAllReceipts();
			if(lstreceipts.isEmpty()){
				
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return lstreceipts;
	}
	
	
 
	
	@RequestMapping(value = "/getreceiptids", method = RequestMethod.GET,headers="Accept=application/json")
	public List<Receipt> getAllReceiptIds()
	{
		List<Receipt> lstreceipts = null;
		try{
			lstreceipts = receiptService.getReceiptIds();
			if(lstreceipts.isEmpty()){
				
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return lstreceipts;
	}
	
	
    @RequestMapping(value = "/getproductsubcat", method = RequestMethod.GET, headers="Accept=application/json")
    public ResponseEntity<List<ProductSubCat>> listProductSubCat() {
    	List<ProductSubCat> lstProdSubCat = receiptService.getAllProductSub();
    	if(lstProdSubCat.isEmpty()){
            return new ResponseEntity<List<ProductSubCat>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<ProductSubCat>>(lstProdSubCat, HttpStatus.OK);
    }
    
    
/*    @RequestMapping(value = "/getjsbsreceipt", method = RequestMethod.GET, headers="Accept=application/json")
    public List<Receipt> listJsbsReceipts(@RequestBody String agentCode) {
    	List<Receipt> lstreceipts = null;
		try{
			lstreceipts = receiptService.getAllJsbsReceipt(agentCode);
		}catch(Exception e){
			e.printStackTrace();
		}
    	return lstreceipts;
    }
*/
    
	@RequestMapping(value = "/getjsbsreceipt/{agentCode}", method = RequestMethod.GET,headers="Accept=application/json")
	public List<Receipt> getAllCustomersByAgentId(@PathVariable String agentCode)
	{
		List<Receipt> lstCustomers=null;
		try{
			lstCustomers = receiptService.getAllJsbsReceipt(agentCode);
		}catch(Exception e){
			e.printStackTrace();
		}
		return lstCustomers;
	}

    
	
}
