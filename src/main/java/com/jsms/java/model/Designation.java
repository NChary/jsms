package com.jsms.java.model;

public class Designation {
	private int id;
	private String designationCode;
	private String designation;
	private boolean status;
	
	
	public Designation() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDesignationCode() {
		return designationCode;
	}
	public void setDesignationCode(String designationCode) {
		this.designationCode = designationCode;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}



	@Override
	public String toString() {
		return "Designation [id=" + id + ", designationCode=" + designationCode + ", designation=" + designation
				+ ", status=" + status + "]";
	}

	
}
