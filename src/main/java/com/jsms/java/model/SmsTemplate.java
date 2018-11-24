package com.jsms.java.model;

public class SmsTemplate {
	private String userName;
	private String password;
	private String mobieNo;
	private String senderName;
	private String sms;
	private int routeType;
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getMobieNo() {
		return mobieNo;
	}
	public void setMobieNo(String mobieNo) {
		this.mobieNo = mobieNo;
	}
	public String getSenderName() {
		return senderName;
	}
	public void setSenderName(String senderName) {
		this.senderName = senderName;
	}
	public String getSms() {
		return sms;
	}
	public void setSms(String sms) {
		this.sms = sms;
	}
	public int getRouteType() {
		return routeType;
	}
	public void setRouteType(int routeType) {
		this.routeType = routeType;
	}
	@Override
	public String toString() {
		return "SmsTemplate [userName=" + userName + ", password=" + password + ", mobieNo=" + mobieNo + ", senderName="
				+ senderName + ", sms=" + sms + ", routeType=" + routeType + "]";
	}
	
	
}
