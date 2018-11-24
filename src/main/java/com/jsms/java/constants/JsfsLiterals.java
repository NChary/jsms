package com.jsms.java.constants;

import com.jsms.java.model.ErrorLog;

public class JsfsLiterals {

	public static final int EMPLOYEE=1;
	
	// Employee
	public static final int EMP_CODE_MIN = 10000;
	public static final int EMP_CODE_MAX = 100000;
	
	// Agent
	public static final int AGENT_CODE_MIN = 100000;
	public static final int AGENT_CODE_MAX = 999999;

	// Employee Code
	public static int EMPLOYEE_ID=10000;
	
	// Branch Code
	public static String BRANCH_PREFIX = "JSF";
	public static String RECEIPT_PREFIX="CR";
	//public static int BRANCH_CODE = 001;
	
	// Customer
	public static final String INVALID_CARD_NO="Invalid card and choose another card";
	
	
	// SMS Details
	public static final String SMS_USERNAME = "jayasreefintrin";
	public static final String SMS_PASSWORD="jayasreefintrin9";
	public static final String SMS_SENDER_NAME="JGROUP";

	
	// RESTFul Response Messages
	public static final String RESPONSE_SUCCESS = "Success";
	public static final String RESPONSE_FAIL = "Fail";
	public static final String CREATE_BRANCH_SUCCESS = "Branch is created successfully";
	public static final String CREATE_BRANCH_FAIL = "Unable to create Branch";
	public static final String CREATE_EMPLOYEE_SUCCESS = "Employee is created successfully";
	public static final String UPDATE_EMPLOYEE_SUCCESS = "Employee details updated successfully";
	public static final String UPDATE_EMPLOYEE_FAIL = "Unable to update Employee details";
	public static final String CREATE_EMPLOYEE_FAIL = "Unable to create Employee";
	public static final String CREATE_CUSTOMER_SUCCESS = "Customer is created successfully";
	public static final String CREATE_CUSTOMER_FAIL = "Unable to create Customer";
	
	public static final String CREATE_AGENT_SUCCESS = "Agent is created successfully";
	public static final String CREATE_AGENT_FAIL = "Unable to create Agent";
	
	public static final String UPDATE_AGENT_SUCCESS = "Agent details updated successfully";
	public static final String UPDATE_AGENT_FAIL = "Fail to update Agent details";
	
	public static final String CREATE_CUSTOMER = "Customer is created successfully";
	public static final String CREATE_RECEIPT_SUCCESS = "Receipt generated Successfully";
	public static final String CREATE_RECEIPT_FAIL = "Unable to generate Receipt";
	
	public static final String LOGIN_SUCCESS = "Login Successfull";
	public static final String CHANGE_PASSWORD_SUCCESS = "Password changed successfully";
	public static final String CHANGE_PASSWORD_FAIL = "Unable to change password";
	
	public static final String INVALID_CARD = "Invalid Card Details";

	public static final String AGENT_GENERATION_TYPE="AGENT";
	public static final String CUSTOMER_GENERATION_TYPE="CUSTOMER";
	
	
	// User Types
	public static final int EMPLOYEE_CODE=2;
	public static final int AGENT_CODE=3;
	public static final int CUSTOMER_CODE=4;
	
	//public static final String UPLOAD_IMAGE_FILE_URL="E:/CHARY_WORKSPACE/Softwares/tomcat8/webapps/employeeimages/";
	public static final String IMAGE_EXTENSION = ".png";
	public static final String BASE_URL="http://115.98.76.126:8080/images/";
	public static final String UPLOAD_URL = "C:/images/";
	
	// Commission structure
	public static final String PRODUCT_BONANZA_NEW_BUSINESS = "jsbsNewBusiness";
	public static final String PRODUCT_BONANZA_RENEWAL_BUSINESS = "jsbsRenewalBusiness";
	public static final String PRODUCT_INSURANCE = "jsis";
	public static final String PRODUCT = "product";
	public static final String PRODUCT_REALESTATE_NEW_BUSINESS = "jsrsNewBusiness";
	public static final String PRODUCT_REALESTATE_RENEWAL_BUSINESS = "jsrsRenewalBusiness";
	public static final String PRODUCT_LOANS = "jsls";
	
	
	public static final String DEFAULT_AGENT_CODE="999999";
	public static final int DEFAULT_CADER_TYPE = 1;
	
	
	// Messages
	public static final String FETCH_CUSTOMER_CODE = "901";
	public static final String FETCH_CUSTOMER_DETAILS = "Unable to fetch Customer details at this time";
	
	public static final String FETCH_AGENT_CODE = "902";
	public static final String FETCH_AGENT_DETAILS = "Unable to fetch Agent details at this time";
	
	public static final String AGENT_FAIL = "Unable to create agent";
	
	public static String getUpperCase(String value){
		return value.toUpperCase().trim();
	}
	
	
	public static ErrorLog getErrorLog(String className,String methodName,String requestData,String empCode,String agentCode,
			String customerCode,String exceptionText){
		ErrorLog errorLog = new ErrorLog();
		errorLog.setClassName(className);
		errorLog.setExceptionText(methodName);
		errorLog.setRequestData(requestData);
		errorLog.setEmployeeCode(String.valueOf(empCode));
		errorLog.setAgentCode(agentCode);
		errorLog.setCustomerCode(customerCode);
		errorLog.setExceptionText(exceptionText);
		return errorLog;
	}
	
	// Validate image URL
	public static boolean isImgUrlValid(String imageURL){
		
		if(imageURL!=null && imageURL.contains("base64")){
			return true;
		}else{
			return false;
		}
	}
}
