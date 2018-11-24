package com.jsms.java.model;

public class AgentDashboard {
	private double totalbusiness;
	private double totalcommission;
	private int noofCustomers;
	public double getTotalbusiness() {
		return totalbusiness;
	}
	public void setTotalbusiness(double totalbusiness) {
		this.totalbusiness = totalbusiness;
	}
	public double getTotalcommission() {
		return totalcommission;
	}
	public void setTotalcommission(double totalcommission) {
		this.totalcommission = totalcommission;
	}
	public int getNoofCustomers() {
		return noofCustomers;
	}
	public void setNoofCustomers(int noofCustomers) {
		this.noofCustomers = noofCustomers;
	}
	@Override
	public String toString() {
		return "AgentDashboard [totalbusiness=" + totalbusiness + ", totalcommission=" + totalcommission
				+ ", noofCustomers=" + noofCustomers + "]";
	}


}
