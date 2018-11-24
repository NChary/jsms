package com.jsms.java.model;

public class Caste {
	private int id;
	private String casteName;
	

	public Caste() {
		// TODO Auto-generated constructor stub
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getCasteName() {
		return casteName;
	}


	public void setCasteName(String casteName) {
		this.casteName = casteName;
	}


	@Override
	public String toString() {
		return "Caste [id=" + id + ", casteName=" + casteName + "]";
	}
	
	
}
