package com.jsms.java.model;

public class AgentBankDetails {
	private int id;
	private int bankId;
	private String accountType;
	private String accountNo;
	private String since;
	private boolean status;
	private int agentId;
	private String ifscCode;	
	
	public String getIfscCode() {
		return ifscCode;
	}
	public void setIfscCode(String ifscCode) {
		this.ifscCode = ifscCode;
	}
	public int getAgentId() {
		return agentId;
	}
	public void setAgentId(int agentId) {
		this.agentId = agentId;
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
		return "AgentBankDetails [id=" + id + ", bankId=" + bankId + ", accountType=" + accountType + ", accountNo="
				+ accountNo + ", since=" + since + ", status=" + status + ", agentId=" + agentId + ", ifscCode="
				+ ifscCode + "]";
	}
	
	
	
	
}
