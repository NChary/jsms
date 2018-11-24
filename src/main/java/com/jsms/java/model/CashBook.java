package com.jsms.java.model;

public class CashBook {
	private int id;
	private int receiptType;
	private int transactionType;
	private int voucherId;
	private double openingBalance;
	private double transactionAmount;
	private double closingBalance;
	private String transactionDate;
	private String createdDate;
	private String paymentType;
	
	
	public String getPaymentType() {
		return paymentType;
	}
	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}
	public String getTransactionDate() {
		return transactionDate;
	}
	public void setTransactionDate(String transactionDate) {
		this.transactionDate = transactionDate;
	}
	public String getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getReceiptType() {
		return receiptType;
	}
	public void setReceiptType(int receiptType) {
		this.receiptType = receiptType;
	}
	public int getTransactionType() {
		return transactionType;
	}
	public void setTransactionType(int transactionType) {
		this.transactionType = transactionType;
	}
	public int getVoucherId() {
		return voucherId;
	}
	public void setVoucherId(int voucherId) {
		this.voucherId = voucherId;
	}
	public double getOpeningBalance() {
		return openingBalance;
	}
	public void setOpeningBalance(double openingBalance) {
		this.openingBalance = openingBalance;
	}
	public double getTransactionAmount() {
		return transactionAmount;
	}
	public void setTransactionAmount(double transactionAmount) {
		this.transactionAmount = transactionAmount;
	}
	public double getClosingBalance() {
		return closingBalance;
	}
	public void setClosingBalance(double closingBalance) {
		this.closingBalance = closingBalance;
	}
	@Override
	public String toString() {
		return "CashBook [id=" + id + ", receiptType=" + receiptType + ", transactionType=" + transactionType
				+ ", voucherId=" + voucherId + ", openingBalance=" + openingBalance + ", transactionAmount="
				+ transactionAmount + ", closingBalance=" + closingBalance + ", transactionDate=" + transactionDate
				+ ", createdDate=" + createdDate + "]";
	}
	
	
}
