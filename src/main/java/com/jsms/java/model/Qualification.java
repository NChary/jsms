package com.jsms.java.model;

public class Qualification {
	private int id;
	private String qualificationName;
	

	public Qualification() {
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getQualificationName() {
		return qualificationName;
	}
	public void setQualificationName(String qualificationName) {
		this.qualificationName = qualificationName;
	}
	@Override
	public String toString() {
		return "Qualification [id=" + id + ", qualificationName=" + qualificationName + "]";
	}
	
}
