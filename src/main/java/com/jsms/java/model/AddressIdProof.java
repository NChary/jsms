package com.jsms.java.model;

public class AddressIdProof {
	private int id;
	private String proofName;
	private boolean status;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getProofName() {
		return proofName;
	}
	public void setProofName(String proofName) {
		this.proofName = proofName;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	
	@Override
	public String toString() {
		return "AddressIdProof [id=" + id + ", proofName=" + proofName + ", status=" + status + "]";
	}	
}
