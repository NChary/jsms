package com.jsms.java.model;

public class CustomerBankDetails {
	private int id;
	private int bankId;
	private String accountType;
	private String accountNo;
	private String since;
	private boolean status;
	private int customerId;
	
	
	
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
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
		return "CustomerBankDetails [id=" + id + ", bankId=" + bankId + ", accountType=" + accountType + ", accountNo="
				+ accountNo + ", since=" + since + ", status=" + status + ", customerId=" + customerId + "]";
	}
	
	
	
	
}
