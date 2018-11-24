package com.jsms.java.model;

public class BankerDetails {
	private int id;
	private int bankId;
	private String accountType;
	private String accountNo;
	private String since;
	private boolean status;
	private int refId;
	private int userType;
	private String ifscCode;	
	private String branch;
	
	public BankerDetails(){
		
	}
	
	
	
	public String getBranch() {
		return branch;
	}


	public void setBranch(String branch) {
		this.branch = branch;
	}


	public int getUserType() {
		return userType;
	}
	public void setUserType(int userType) {
		this.userType = userType;
	}
	public String getIfscCode() {
		return ifscCode;
	}
	public void setIfscCode(String ifscCode) {
		this.ifscCode = ifscCode;
	}
	
	public int getRefId() {
		return refId;
	}
	public void setRefId(int refId) {
		this.refId = refId;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getBankId() {
		return bankId;
	}
	public void setBankId(int bankId) {
		this.bankId = bankId;
	}
	 
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public String getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}
	public String getSince() {
		return since;
	}
	public void setSince(String since) {
		this.since = since;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}



	@Override
	public String toString() {
		return "BankerDetails [id=" + id + ", bankId=" + bankId + ", accountType=" + accountType + ", accountNo="
				+ accountNo + ", since=" + since + ", status=" + status + ", refId=" + refId + ", userType=" + userType
				+ ", ifscCode=" + ifscCode + ", branch=" + branch + "]";
	}
	
	
	
	
}
