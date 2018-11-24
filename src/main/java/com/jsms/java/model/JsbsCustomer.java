package com.jsms.java.model;

public class JsbsCustomer {
	
	private long id;
	private String jsbsCode;
	private String customerId;
	private String agentCode;
	private long jsbsReceiptId;
	private String branchCode;
	private String jsbsGroup;
	private String groupStartDate;
	private long installmentNo;
	private double openingBalance;
	private double paidAmount;
	private double balanceAmount;
	private String careatedDate;
	private int status;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getJsbsCode() {
		return jsbsCode;
	}
	public void setJsbsCode(String jsbsCode) {
		this.jsbsCode = jsbsCode;
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public String getAgentCode() {
		return agentCode;
	}
	public void setAgentCode(String agentCode) {
		this.agentCode = agentCode;
	}
	public long getJsbsReceiptId() {
		return jsbsReceiptId;
	}
	public void setJsbsReceiptId(long jsbsReceiptId) {
		this.jsbsReceiptId = jsbsReceiptId;
	}
	public String getBranchCode() {
		return branchCode;
	}
	public void setBranchCode(String branchCode) {
		this.branchCode = branchCode;
	}
	public String getJsbsGroup() {
		return jsbsGroup;
	}
	public void setJsbsGroup(String jsbsGroup) {
		this.jsbsGroup = jsbsGroup;
	}
	public String getGroupStartDate() {
		return groupStartDate;
	}
	public void setGroupStartDate(String groupStartDate) {
		this.groupStartDate = groupStartDate;
	}
	public long getInstallmentNo() {
		return installmentNo;
	}
	public void setInstallmentNo(long installmentNo) {
		this.installmentNo = installmentNo;
	}
	public double getOpeningBalance() {
		return openingBalance;
	}
	public void setOpeningBalance(double openingBalance) {
		this.openingBalance = openingBalance;
	}
	public double getPaidAmount() {
		return paidAmount;
	}
	public void setPaidAmount(double paidAmount) {
		this.paidAmount = paidAmount;
	}
	public double getBalanceAmount() {
		return balanceAmount;
	}
	public void setBalanceAmount(double balanceAmount) {
		this.balanceAmount = balanceAmount;
	}
	public String getCareatedDate() {
		return careatedDate;
	}
	public void setCareatedDate(String careatedDate) {
		this.careatedDate = careatedDate;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "JsbsCustomer [id=" + id + ", jsbsCode=" + jsbsCode + ", customerId=" + customerId + ", agentCode="
				+ agentCode + ", jsbsReceiptId=" + jsbsReceiptId + ", branchCode=" + branchCode + ", jsbsGroup="
				+ jsbsGroup + ", groupStartDate=" + groupStartDate + ", installmentNo=" + installmentNo
				+ ", openingBalance=" + openingBalance + ", paidAmount=" + paidAmount + ", balanceAmount="
				+ balanceAmount + ", careatedDate=" + careatedDate + ", status=" + status + "]";
	}
	
	
}
