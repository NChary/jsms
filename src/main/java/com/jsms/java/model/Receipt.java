package com.jsms.java.model;

public class Receipt {
	private int id;
	private int receiptType;
	private double amount;
	private String submittedBy;
	private int paymentTypeId;
	private String paymentType;
	private String branchId;
	private String date;
	private int createdBy;
	private String createdDate;
	private int udpatedBy;
	private String updatedDate;
	private String status;
	private int userType;
	private String jsbsCustomerCode;
	private int agentCader=2;
		

	public String getPaymentType() {
		return paymentType;
	}
	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}
	public String getJsbsCustomerCode() {
		return jsbsCustomerCode;
	}
	public void setJsbsCustomerCode(String jsbsCustomerCode) {
		this.jsbsCustomerCode = jsbsCustomerCode;
	}
	public int getAgentCader() {
		return agentCader;
	}
	public void setAgentCader(int agentCader) {
		this.agentCader = agentCader;
	}
	public int getUserType() {
		return userType;
	}
	public void setUserType(int userType) {
		this.userType = userType;
	}
	public int getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(int createdBy) {
		this.createdBy = createdBy;
	}
	public String getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}
	public int getUdpatedBy() {
		return udpatedBy;
	}
	public void setUdpatedBy(int udpatedBy) {
		this.udpatedBy = udpatedBy;
	}
	public String getUpdatedDate() {
		return updatedDate;
	}
	public void setUpdatedDate(String updatedDate) {
		this.updatedDate = updatedDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getReceiptType() {
		return receiptType;
	}
	public void setReceiptType(int receiptType) {
		this.receiptType = receiptType;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getSubmittedBy() {
		return submittedBy;
	}
	public void setSubmittedBy(String submittedBy) {
		this.submittedBy = submittedBy;
	}
	public int getPaymentTypeId() {
		return paymentTypeId;
	}
	public void setPaymentTypeId(int paymentTypeId) {
		this.paymentTypeId = paymentTypeId;
	}
	
	public String getBranchId() {
		return branchId;
	}
	public void setBranchId(String branchId) {
		this.branchId = branchId;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "Receipt [id=" + id + ", receiptType=" + receiptType + ", amount=" + amount + ", submittedBy="
				+ submittedBy + ", paymentTypeId=" + paymentTypeId + ", branchId=" + branchId + ", date=" + date
				+ ", createdBy=" + createdBy + ", createdDate=" + createdDate + ", udpatedBy=" + udpatedBy
				+ ", updatedDate=" + updatedDate + ", status=" + status + ", userType=" + userType
				+ ", jsbsCustomerCode=" + jsbsCustomerCode + ", agentCader=" + agentCader + "]";
	}

	
}
