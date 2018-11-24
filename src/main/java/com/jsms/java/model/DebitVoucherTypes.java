package com.jsms.java.model;

public class DebitVoucherTypes {
	private int id;
	private String expenditureType;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getExpenditureType() {
		return expenditureType;
	}
	public void setExpenditureType(String expenditureType) {
		this.expenditureType = expenditureType;
	}
	@Override
	public String toString() {
		return "DebitVoucherTypes [id=" + id + ", expenditureType=" + expenditureType + "]";
	}
	
	
}
