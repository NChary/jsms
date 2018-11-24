package com.jsms.java.model;

public class BankDetails {

	private int id;
	private String bankName;
	private String branch;
	private String address;
	private String contactNo;
	private int cityId;
	private String ifscCode;
	private String micrCode;
	private boolean status;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getContactNo() {
		return contactNo;
	}
	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}
	public int getCityId() {
		return cityId;
	}
	public void setCityId(int cityId) {
		this.cityId = cityId;
	}
	public String getIfscCode() {
		return ifscCode;
	}
	public void setIfscCode(String ifscCode) {
		this.ifscCode = ifscCode;
	}
	public String getMicrCode() {
		return micrCode;
	}
	public void setMicrCode(String micrCode) {
		this.micrCode = micrCode;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "BankDetails [id=" + id + ", bankName=" + bankName + ", branch=" + branch + ", address=" + address
				+ ", contactNo=" + contactNo + ", cityId=" + cityId + ", ifscCode=" + ifscCode + ", micrCode="
				+ micrCode + ", status=" + status + "]";
	}
	
	
}
