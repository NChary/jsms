package com.jsms.java.model;

public class ProductSubCat {
	private int id;
	private String subCatType;
	private int categoryTypeId;
	private int status;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSubCatType() {
		return subCatType;
	}
	public void setSubCatType(String subCatType) {
		this.subCatType = subCatType;
	}
	public int getCategoryTypeId() {
		return categoryTypeId;
	}
	public void setCategoryTypeId(int categoryTypeId) {
		this.categoryTypeId = categoryTypeId;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "ProductSubCat [id=" + id + ", subCatType=" + subCatType + ", categoryTypeId=" + categoryTypeId
				+ ", status=" + status + "]";
	}
	
}
