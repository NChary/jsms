package com.jsms.java.dao;

import java.util.List;

import com.jsms.java.model.AddressIdProof;
import com.jsms.java.model.BankDetails;
import com.jsms.java.model.BloodGroups;
import com.jsms.java.model.CardDetails;
import com.jsms.java.model.Caste;
import com.jsms.java.model.Designation;
import com.jsms.java.model.Qualification;
import com.jsms.java.model.VehicleType;

public interface DropDownDao {
	List<Designation> getAllDesignations();
	List<VehicleType> getVehicleType();
	List<Caste> getAllCastes();
	List<Qualification> getAllQualifications();
	List<BloodGroups> getAllBloodGroups();
	List<BankDetails> getAllBanks();
	List<CardDetails> getAllCardDetails();
	List<AddressIdProof> getAllIdProofs();
	List<AddressIdProof> getAllAddressProofs();
	List<Designation> getAllCaders();
}
