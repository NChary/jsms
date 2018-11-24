package com.jsms.java.model;

public class VehicleType {
	private int id;
	private String vehicleType;
	

	public VehicleType() {
		// TODO Auto-generated constructor stub
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public String getVehicleType() {
		return vehicleType;
	}

	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}

	@Override
	public String toString() {
		return "VehicleType [id=" + id + ", vehicleType=" + vehicleType + "]";
	}

	
}
