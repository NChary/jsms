package com.jsms.java.model;

public class Employee {
	
	private int id;
	private int empCode;
	private String password;
	private String branchId;
	private int designationId;
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
	private String bloodGroup;
	private String spouseName;
	private int spouseAge;
	private String spouseMobileNo;
	private int  noOfMaleChildrens;
	private int noOfFemailChildrens;
	private String vehicleType;
	private String vehicleNo;
	private int idProofId;
	private String idProofNo;
	private int addressProofId;
	private String addressProofNo;
	
	private String employeeParticulars;
	private String applicantImage;
	private BankerDetails bankerDetails;
	private double salary;
	
	private int createdBy;
	private String createdDate;
	private int updatedBy;
	private String updatedDate;
	private int status;
	
	private String idProofImage;
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

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public BankerDetails getBankerDetails() {
		return bankerDetails;
	}

	public void setBankerDetails(BankerDetails bankerDetails) {
		this.bankerDetails = bankerDetails;
	}

	public Employee(){
		
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getEmpCode() {
		return empCode;
	}
	public void setEmpCode(int empCode) {
		this.empCode = empCode;
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
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	
	public String getBranchId() {
		return branchId;
	}

	public void setBranchId(String branchId) {
		this.branchId = branchId;
	}

	public int getDesignationId() {
		return designationId;
	}
	public void setDesignationId(int designationId) {
		this.designationId = designationId;
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
	public int getQualification() {
		return qualificationId;
	}
	public void setQualification(int qualification) {
		this.qualificationId = qualification;
	}
	public int getCaste() {
		return casteId;
	}
	public void setCaste(int caste) {
		this.casteId = caste;
	}
	public String getMaritalStatus() {
		return maritalStatus;
	}
	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}
	public String getBloodGroup() {
		return bloodGroup;
	}
	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
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
	public int getNoOfMaleChildrens() {
		return noOfMaleChildrens;
	}
	public void setNoOfMaleChildrens(int noOfMaleChildrens) {
		this.noOfMaleChildrens = noOfMaleChildrens;
	}
	public int getNoOfFemailChildrens() {
		return noOfFemailChildrens;
	}
	public void setNoOfFemailChildrens(int noOfFemailChildrens) {
		this.noOfFemailChildrens = noOfFemailChildrens;
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
	
	public String getEmployeeParticulars() {
		return employeeParticulars;
	}
	public void setEmployeeParticulars(String employeeParticulars) {
		this.employeeParticulars = employeeParticulars;
	}

	public String getApplicantImage() {
		return applicantImage;
	}

	public void setApplicantImage(String applicantImage) {
		this.applicantImage = applicantImage;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", empCode=" + empCode + ", password=" + password + ", branchId=" + branchId
				+ ", designationId=" + designationId + ", name=" + name + ", surName=" + surName + ", fatherName="
				+ fatherName + ", dob=" + dob + ", age=" + age + ", presentAddress=" + presentAddress
				+ ", permanentAddress=" + permanentAddress + ", mobileNo=" + mobileNo + ", landNo=" + landNo
				+ ", email=" + email + ", house=" + house + ", office=" + office + ", qualificationId="
				+ qualificationId + ", casteId=" + casteId + ", maritalStatus=" + maritalStatus + ", bloodGroup="
				+ bloodGroup + ", spouseName=" + spouseName + ", spouseAge=" + spouseAge + ", spouseMobileNo="
				+ spouseMobileNo + ", noOfMaleChildrens=" + noOfMaleChildrens + ", noOfFemailChildrens="
				+ noOfFemailChildrens + ", vehicleType=" + vehicleType + ", vehicleNo=" + vehicleNo + ", idProofId="
				+ idProofId + ", idProofNo=" + idProofNo + ", addressProofId=" + addressProofId + ", addressProofNo="
				+ addressProofNo + ", employeeParticulars=" + employeeParticulars + ", applicantImage=" + applicantImage
				+ ", bankerDetails=" + bankerDetails + ", salary=" + salary + ", createdBy=" + createdBy
				+ ", createdDate=" + createdDate + ", updatedBy=" + updatedBy + ", updatedDate=" + updatedDate
				+ ", status=" + status + ", idProofImage=" + idProofImage + ", addressProofImage=" + addressProofImage
				+ "]";
	}
	
	
	
}
