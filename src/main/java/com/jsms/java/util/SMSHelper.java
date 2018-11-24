package com.jsms.java.util;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jsms.java.constants.JsfsLiterals;
import com.jsms.java.dao.CommonDao;
@Component
public class SMSHelper {

	private final String USER_AGENT = "Mozilla/5.0";

	@Autowired
	private CommonDao commonDao;
	
	
	public void sendSMSToEmployee(long empCode,String mobileNo,String password){
		String message="";
		try {
			message = "Welcome to JAYASREE GROUP;Your Id:"+empCode+"; Login ID:" + empCode + ";Password:"+ password+"; Login from - www.jayasreecorp.com;";
			sendSMS(mobileNo, message);
		} catch(Exception ex) {
			commonDao.saveErrorLog(JsfsLiterals.getErrorLog(this.getClass().getSimpleName(), 
									"sendSMSToEmployee", message, String.valueOf(empCode), "", "", ex.toString()));
		}
	}

	public void sendSMSToAgent(long agentCode,String cader,String mobileNo,String password){
		String message="";
		try {
			 message="Welcome to JS Group, You are successfully registered as "+cader+", Your ID: "+agentCode+", Password: "+password+", Login http://www.jayasreecorp.com, Happy Joining - Admin";
			//String message = "Welcome to JAYASREE GROUP;Your Id:"+empCode+"; Login ID:" + empCode + ";Password:"+ password+"; Login from - www.jayasreecorp.com;";
			sendSMS(mobileNo, message);
		} catch(Exception ex) {
			commonDao.saveErrorLog(JsfsLiterals.getErrorLog(this.getClass().getSimpleName(), 
									"sendSMSToAgent", message, "", String.valueOf(agentCode), "", ex.toString()));
		
		}
	}
	
	public void sendSMSToCustomer(String customerCode,String mobileNo,String password){
		String message="";
		try {
			message = "Welcome to JAYASREE GROUP;Your Id:"+customerCode+"; Login ID:" + customerCode + ";Password:"+ password+"; Login from - www.jayasreecorp.com;";
			sendSMS(mobileNo, message);
		} catch(Exception ex) {
			commonDao.saveErrorLog(JsfsLiterals.getErrorLog(this.getClass().getSimpleName(), 
					"sendSMSToCustomer", message, "", "", customerCode, ex.toString()));
		}
	}


	public void sendReceiptSMSToAgent(long frn,String mobileNo){
		try {
			String message = "You are successfully generated your FRN for registering your Customer. Your FRN no is "+JsfsLiterals.RECEIPT_PREFIX+""+frn+" Continue to register. Happy Joining - Admin.";
			//String message = "Welcome to JAYASREE GROUP;Your FRN : " + JsfsLiterals.RECEIPT_PREFIX+""+frn+"; Use this FRN to register customer.";
			sendSMS(mobileNo, message);
		} catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
	}

	public void sendSMSToForgotUser(String mobileNo,String accountNo,String password){
		try {
			String message = "Your Account No: "+accountNo+"password : "+password;
			sendSMS(mobileNo, message);
		} catch(Exception ex) {
			System.out.println(ex.getMessage());
		}

	}


	public void sendCardDetailsToCustomer(String mobileNo,String cardNo){

		try {
			String message=" Your card no is "+cardNo+" and Welcome Kit will be dispatch shortly, for any quarries call us on 040 - 65 65 65 85. Happy Selling - Admin";
			sendSMS(mobileNo, message);
		} catch(Exception ex) {
			System.out.println(ex.getMessage());
		}

	}

	public void sendSMS(String mobileNo,String message){
		try {
			String requestUrl  = "http://mahaoffers.in/SMS_API/sendsms.php?" +
					"username=" + URLEncoder.encode(JsfsLiterals.SMS_USERNAME, "UTF-8") +
					"&password=" + URLEncoder.encode(JsfsLiterals.SMS_PASSWORD, "UTF-8") +
					"&mobile=" + URLEncoder.encode(mobileNo, "UTF-8") +
					"&sendername=" + URLEncoder.encode(JsfsLiterals.SMS_SENDER_NAME, "UTF-8") +
					"&message=" + URLEncoder.encode(message, "UTF-8") +
					"&routetype=1";
			URL url = new URL(requestUrl);
			HttpURLConnection uc = (HttpURLConnection)url.openConnection();
			System.out.println(requestUrl+" "+uc.getResponseMessage());
			uc.disconnect();
			
			//Insert into info log
			commonDao.saveSmsInfoLog(mobileNo, message);
			
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


}
