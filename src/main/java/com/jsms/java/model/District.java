package com.jsms.java.model;

public class District{
	private int id;
	private String districtName;
	private int stateId;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDistrictName() {
		return districtName;
	}
	public void setDistrictName(String districtName) {
		this.districtName = districtName;
	}
	public int getStateId() {
		return stateId;
	}
	public void setStateId(int stateId) {
		this.stateId = stateId;
	}
	@Override
	public String toString() {
		return "District [id=" + id + ", districtName=" + districtName + ", stateId=" + stateId + "]";
	}
	
}
