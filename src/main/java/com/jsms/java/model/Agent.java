package com.jsms.java.model;

import java.io.Serializable;

public class Agent implements Serializable{
	private int id;
	private String agentCode;
	private String password;
	private String name;
	private String surName;
	private String fatherName;
	private String dob;
	private int age;
	private String presentAddress;
	private String permanentAddress;
	private String mobileNo;
	private String landNo;
	private String email;
	private String house;
	private String office;
	private int qualificationId;
	private int casteId;
	private String maritalStatus;
	private int bloodGroupId;
	private String spouseName;
	private int spouseAge;
	private String spouseMobileNo;
	private int  childrenMale;
	private int childrenFemale;
	private String vehicleType;
	private String vehicleNo;
	private int idProofId;
	private String idProofNo;
	private String idProofImage;
	private int addressProofId ;
	private String addressProofImage;
	public String getIdProofImage() {
		return idProofImage;
	}
	public void setIdProofImage(String idProofImage) {
		this.idProofImage = idProofImage;
	}
	public String getAddressProofImage() {
		return addressProofImage;
	}
	public void setAddressProofImage(String addressProofImage) {
		this.addressProofImage = addressProofImage;
	}
	private String addressProofNo;
	private String agentParticulars;
	private String applicantImage;
	private ReferenceDetails refDetails;
	private int caderId;
	private String sagentCode;
	private BankerDetails bankerDetails;
	private int sagentCaderId;
	
	private int createdBy;
	private String createdDate;
	private int updatedBy;
	private String updatedDate;
	private int status;
	
	
	
	public int getSagentCaderId() {
		return sagentCaderId;
	}
	public void setSagentCaderId(int sagentCaderId) {
		this.sagentCaderId = sagentCaderId;
	}
	public BankerDetails getBankerDetails() {
		return bankerDetails;
	}
	public void setBankerDetails(BankerDetails bankerDetails) {
		this.bankerDetails = bankerDetails;
	}
	public int getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(int createdBy) {
		this.createdBy = createdBy;
	}
	public String getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}
	public int getUpdatedBy() {
		return updatedBy;
	}
	public void setUpdatedBy(int updatedBy) {
		this.updatedBy = updatedBy;
	}
	public String getUpdatedDate() {
		return updatedDate;
	}
	public void setUpdatedDate(String updatedDate) {
		this.updatedDate = updatedDate;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getIdProofId() {
		return idProofId;
	}
	public void setIdProofId(int idProofId) {
		this.idProofId = idProofId;
	}
	public String getIdProofNo() {
		return idProofNo;
	}
	public void setIdProofNo(String idProofNo) {
		this.idProofNo = idProofNo;
	}
	public int getAddressProofId() {
		return addressProofId;
	}
	public void setAddressProofId(int addressProofId) {
		this.addressProofId = addressProofId;
	}
	public String getAddressProofNo() {
		return addressProofNo;
	}
	public void setAddressProofNo(String addressProofNo) {
		this.addressProofNo = addressProofNo;
	}
	public String getSagentCode() {
		return sagentCode;
	}
	public void setSagentCode(String sagentCode) {
		this.sagentCode = sagentCode;
	}
	public int getCaderId() {
		return caderId;
	}
	public void setCaderId(int caderId) {
		this.caderId = caderId;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAgentCode() {
		return agentCode;
	}
	public void setAgentCode(String agentCode) {
		this.agentCode = agentCode;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurName() {
		return surName;
	}
	public void setSurName(String surName) {
		this.surName = surName;
	}
	public String getFatherName() {
		return fatherName;
	}
	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getPresentAddress() {
		return presentAddress;
	}
	public void setPresentAddress(String presentAddress) {
		this.presentAddress = presentAddress;
	}
	public String getPermanentAddress() {
		return permanentAddress;
	}
	public void setPermanentAddress(String permanentAddress) {
		this.permanentAddress = permanentAddress;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getLandNo() {
		return landNo;
	}
	public void setLandNo(String landNo) {
		this.landNo = landNo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getHouse() {
		return house;
	}
	public void setHouse(String house) {
		this.house = house;
	}
	public String getOffice() {
		return office;
	}
	public void setOffice(String office) {
		this.office = office;
	}
	public int getQualificationId() {
		return qualificationId;
	}
	public void setQualificationId(int qualificationId) {
		this.qualificationId = qualificationId;
	}
	public int getCasteId() {
		return casteId;
	}
	public void setCasteId(int casteId) {
		this.casteId = casteId;
	}
	public String getMaritalStatus() {
		return maritalStatus;
	}
	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}
	public int getBloodGroupId() {
		return bloodGroupId;
	}
	public void setBloodGroupId(int bloodGroupId) {
		this.bloodGroupId = bloodGroupId;
	}
	public String getSpouseName() {
		return spouseName;
	}
	public void setSpouseName(String spouseName) {
		this.spouseName = spouseName;
	}
	public int getSpouseAge() {
		return spouseAge;
	}
	public void setSpouseAge(int spouseAge) {
		this.spouseAge = spouseAge;
	}
	public String getSpouseMobileNo() {
		return spouseMobileNo;
	}
	public void setSpouseMobileNo(String spouseMobileNo) {
		this.spouseMobileNo = spouseMobileNo;
	}
	public int getChildrenMale() {
		return childrenMale;
	}
	public void setChildrenMale(int childrenMale) {
		this.childrenMale = childrenMale;
	}
	public int getChildrenFemale() {
		return childrenFemale;
	}
	public void setChildrenFemale(int childrenFemale) {
		this.childrenFemale = childrenFemale;
	}
	public String getVehicleType() {
		return vehicleType;
	}
	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}
	public String getVehicleNo() {
		return vehicleNo;
	}
	public void setVehicleNo(String vehicleNo) {
		this.vehicleNo = vehicleNo;
	}
	
	public String getAgentParticulars() {
		return agentParticulars;
	}
	public void setAgentParticulars(String agentParticulars) {
		this.agentParticulars = agentParticulars;
	}
	public String getApplicantImage() {
		return applicantImage;
	}
	public void setApplicantImage(String applicantImage) {
		this.applicantImage = applicantImage;
	}
	 
	public ReferenceDetails getRefDetails() {
		return refDetails;
	}
	public void setRefDetails(ReferenceDetails refDetails) {
		this.refDetails = refDetails;
	}
	@Override
	public String toString() {
		return "Agent [id=" + id + ", agentCode=" + agentCode + ", password=" + password + ", name=" + name
				+ ", surName=" + surName + ", fatherName=" + fatherName + ", dob=" + dob + ", age=" + age
				+ ", presentAddress=" + presentAddress + ", permanentAddress=" + permanentAddress + ", mobileNo="
				+ mobileNo + ", landNo=" + landNo + ", email=" + email + ", house=" + house + ", office=" + office
				+ ", qualificationId=" + qualificationId + ", casteId=" + casteId + ", maritalStatus=" + maritalStatus
				+ ", bloodGroupId=" + bloodGroupId + ", spouseName=" + spouseName + ", spouseAge=" + spouseAge
				+ ", spouseMobileNo=" + spouseMobileNo + ", childrenMale=" + childrenMale + ", childrenFemale="
				+ childrenFemale + ", vehicleType=" + vehicleType + ", vehicleNo=" + vehicleNo + ", idProofId="
				+ idProofId + ", idProofNo=" + idProofNo + ", idProofImage=" + idProofImage + ", addressProofId="
				+ addressProofId + ", addressProofImage=" + addressProofImage + ", addressProofNo=" + addressProofNo
				+ ", agentParticulars=" + agentParticulars + ", applicantImage=" + applicantImage + ", refDetails="
				+ refDetails + ", caderId=" + caderId + ", sagentCode=" + sagentCode + ", bankerDetails="
				+ bankerDetails + ", sagentCaderId=" + sagentCaderId + ", createdBy=" + createdBy + ", createdDate="
				+ createdDate + ", updatedBy=" + updatedBy + ", updatedDate=" + updatedDate + ", status=" + status
				+ "]";
	}
	
	
}
