package com.jsms.java.model;

public class State {
	private int id;
	private String stateName;
	private int countryId;
	
	
	
	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	public int getCountryId() {
		return countryId;
	}
	public void setCountryId(int countryId) {
		this.countryId = countryId;
	}

	@Override
	public String toString() {
		return "State [id=" + id + ", stateName=" + stateName + ", countryId=" + countryId + "]";
	}
	
	
}
