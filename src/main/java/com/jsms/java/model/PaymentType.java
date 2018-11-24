package com.jsms.java.model;

public class PaymentType {
	private int id;
	private String paymentType;
	private boolean status;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getPaymentType() {
		return paymentType;
	}
	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "PaymentType [id=" + id + ", paymentType=" + paymentType + ", status=" + status + "]";
	}
	
	
}
