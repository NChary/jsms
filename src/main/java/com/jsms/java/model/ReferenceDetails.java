package com.jsms.java.model;

public class ReferenceDetails {
	private int id;
	private String ref1Name;
	private String ref1Occupation;
	private String ref1Address;
	private String ref1MobileNo;
	private String ref1Email;
	private String ref2Name;
	private String ref2Occupation;
	private String ref2Address;
	private String ref2MobileNo;
	private String ref2Email;
	private boolean status;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getRef1Name() {
		return ref1Name;
	}
	public void setRef1Name(String ref1Name) {
		this.ref1Name = ref1Name;
	}
	public String getRef1Occupation() {
		return ref1Occupation;
	}
	public void setRef1Occupation(String ref1Occupation) {
		this.ref1Occupation = ref1Occupation;
	}
	public String getRef1Address() {
		return ref1Address;
	}
	public void setRef1Address(String ref1Address) {
		this.ref1Address = ref1Address;
	}
	public String getRef1MobileNo() {
		return ref1MobileNo;
	}
	public void setRef1MobileNo(String ref1MobileNo) {
		this.ref1MobileNo = ref1MobileNo;
	}
	public String getRef1Email() {
		return ref1Email;
	}
	public void setRef1Email(String ref1Email) {
		this.ref1Email = ref1Email;
	}
	public String getRef2Name() {
		return ref2Name;
	}
	public void setRef2Name(String ref2Name) {
		this.ref2Name = ref2Name;
	}
	public String getRef2Occupation() {
		return ref2Occupation;
	}
	public void setRef2Occupation(String ref2Occupation) {
		this.ref2Occupation = ref2Occupation;
	}
	public String getRef2Address() {
		return ref2Address;
	}
	public void setRef2Address(String ref2Address) {
		this.ref2Address = ref2Address;
	}
	public String getRef2MobileNo() {
		return ref2MobileNo;
	}
	public void setRef2MobileNo(String ref2MobileNo) {
		this.ref2MobileNo = ref2MobileNo;
	}
	public String getRef2Email() {
		return ref2Email;
	}
	public void setRef2Email(String ref2Email) {
		this.ref2Email = ref2Email;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "ReferenceDetails [id=" + id + ", ref1Name=" + ref1Name + ", ref1Occupation=" + ref1Occupation
				+ ", ref1Address=" + ref1Address + ", ref1MobileNo=" + ref1MobileNo + ", ref1Email=" + ref1Email
				+ ", ref2Name=" + ref2Name + ", ref2Occupation=" + ref2Occupation + ", ref2Address=" + ref2Address
				+ ", ref2MobileNo=" + ref2MobileNo + ", ref2Email=" + ref2Email + ", status=" + status + "]";
	}
	
	
}
