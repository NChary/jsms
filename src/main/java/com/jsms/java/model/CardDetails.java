package com.jsms.java.model;

public class CardDetails {
	private int id;
	private String cardNo;
	private int cvvNumber;
	private String createdBy;
	private String createdDate;
	private int status;
	private String fromDate;
	private String toDate;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCardNo() {
		return cardNo;
	}
	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}
	public int getCvvNumber() {
		return cvvNumber;
	}
	public void setCvvNumber(int cvvNumber) {
		this.cvvNumber = cvvNumber;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public String getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getFromDate() {
		return fromDate;
	}
	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}
	public String getToDate() {
		return toDate;
	}
	public void setToDate(String toDate) {
		this.toDate = toDate;
	}
	@Override
	public String toString() {
		return "CardDetails [id=" + id + ", cardNo=" + cardNo + ", cvvNumber=" + cvvNumber + ", createdBy=" + createdBy
				+ ", createdDate=" + createdDate + ", status=" + status + ", fromDate=" + fromDate + ", toDate="
				+ toDate + "]";
	}
	
	
}
