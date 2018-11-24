package com.jsms.java.model;

public class BloodGroups {
	private int id;
	private String bloodGroupName;
	

	public BloodGroups() {
		// TODO Auto-generated constructor stub
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getBloodGroupName() {
		return bloodGroupName;
	}


	public void setBloodGroupName(String bloodGroupName) {
		this.bloodGroupName = bloodGroupName;
	}


	@Override
	public String toString() {
		return "BloodGroups [id=" + id + ", bloodGroupName=" + bloodGroupName + "]";
	}
	
	
}
