package com.jsms.java.model;

public class Dashboard {
	private int noofBranches;
	private int noofEmployees;
	private int noofAgents;
	private int noofCustomers;

	public int getNoofBranches() {
		return noofBranches;
	}
	public void setNoofBranches(int noofBranches) {
		this.noofBranches = noofBranches;
	}
	public int getNoofEmployees() {
		return noofEmployees;
	}
	public void setNoofEmployees(int noofEmployees) {
		this.noofEmployees = noofEmployees;
	}
	public int getNoofAgents() {
		return noofAgents;
	}
	public void setNoofAgents(int noofAgents) {
		this.noofAgents = noofAgents;
	}
	public int getNoofCustomers() {
		return noofCustomers;
	}
	public void setNoofCustomers(int noofCustomers) {
		this.noofCustomers = noofCustomers;
	}
	@Override
	public String toString() {
		return "Dashboard [noofBranches=" + noofBranches + ", noofEmployees=" + noofEmployees + ", noofAgents="
				+ noofAgents + ", noofCustomers=" + noofCustomers + "]";
	}
	
	
}
