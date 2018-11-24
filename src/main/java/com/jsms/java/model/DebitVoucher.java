package com.jsms.java.model;

public class DebitVoucher {

	private int id;
	private String date;
	private int expenditureType;
	private String name;
	private double amount;
	private String description;
	private int paymentType;
	private long createdBy;
	private String agentCode;
	private String employeeCode;
	private String expType;
	private String payType;
	
	
	public String getExpType() {
		return expType;
	}
	public void setExpType(String expType) {
		this.expType = expType;
	}
	public String getPayType() {
		return payType;
	}
	public void setPayType(String payType) {
		this.payType = payType;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getAgentCode() {
		return agentCode;
	}
	public void setAgentCode(String agentCode) {
		this.agentCode = agentCode;
	}
	public String getEmployeeCode() {
		return employeeCode;
	}
	public void setEmployeeCode(String employeeCode) {
		this.employeeCode = employeeCode;
	}
	public int getPaymentType() {
		return paymentType;
	}
	public void setPaymentType(int paymentType) {
		this.paymentType = paymentType;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getExpenditureType() {
		return expenditureType;
	}
	public void setExpenditureType(int expenditureType) {
		this.expenditureType = expenditureType;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public long getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(long createdBy) {
		this.createdBy = createdBy;
	}
	@Override
	public String toString() {
		return "DebitVoucher [id=" + id + ", date=" + date + ", expenditureType=" + expenditureType + ", name=" + name
				+ ", amount=" + amount + ", description=" + description + ", paymentType=" + paymentType
				+ ", createdBy=" + createdBy + ", agentCode=" + agentCode + ", employeeCode=" + employeeCode + "]";
	}
	
}
