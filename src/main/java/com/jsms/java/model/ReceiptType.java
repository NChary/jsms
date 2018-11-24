package com.jsms.java.model;

public class ReceiptType {
	private int id;
	private String receiptType;
	private boolean status;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
	public String getReceiptType() {
		return receiptType;
	}
	public void setReceiptType(String receiptType) {
		this.receiptType = receiptType;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "ReceiptType [id=" + id + ", receiptType=" + receiptType + ", status=" + status + "]";
	}
	
	
}
