package com.jsms.java.model;

public class AgentCommission {
	private int id;
	private String agentcode;
	private double amount;
	private double commission;
	private long receiptId;
	private String date;
	private int status;
	private boolean isGapCommission;
	private int userType;
	
	public int getUserType() {
		return userType;
	}
	public void setUserType(int userType) {
		this.userType = userType;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAgentcode() {
		return agentcode;
	}
	public void setAgentcode(String agentcode) {
		this.agentcode = agentcode;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public double getCommission() {
		return commission;
	}
	public void setCommission(double commission) {
		this.commission = commission;
	}
	 
	public long getReceiptId() {
		return receiptId;
	}
	public void setReceiptId(long receiptId) {
		this.receiptId = receiptId;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public boolean isGapCommission() {
		return isGapCommission;
	}
	public void setGapCommission(boolean isGapCommission) {
		this.isGapCommission = isGapCommission;
	}
	@Override
	public String toString() {
		return "AgentCommission [id=" + id + ", agentcode=" + agentcode + ", amount=" + amount + ", commission="
				+ commission + ", receiptId=" + receiptId + ", date=" + date + ", status=" + status
				+ ", isGapCommission=" + isGapCommission + ", userType=" + userType + "]";
	}
	
	
}
