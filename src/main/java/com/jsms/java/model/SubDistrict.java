package com.jsms.java.model;

public class SubDistrict{
	private int id;
	private String subDistrictName;
	private int districtId;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSubDistrictName() {
		return subDistrictName;
	}
	public void setSubDistrictName(String subDistrictName) {
		this.subDistrictName = subDistrictName;
	}
	public int getDistrictId() {
		return districtId;
	}
	public void setDistrictId(int districtId) {
		this.districtId = districtId;
	}
	@Override
	public String toString() {
		return "SubDistrict [id=" + id + ", subDistrictName=" + subDistrictName + ", districtId=" + districtId + "]";
	}
	
	
}
