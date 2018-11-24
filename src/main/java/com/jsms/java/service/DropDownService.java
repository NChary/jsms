package com.jsms.java.service;

import java.util.List;

import com.jsms.java.model.AddressIdProof;
import com.jsms.java.model.BankDetails;
import com.jsms.java.model.BloodGroups;
import com.jsms.java.model.CardDetails;
import com.jsms.java.model.Caste;
import com.jsms.java.model.Designation;
import com.jsms.java.model.District;
import com.jsms.java.model.Qualification;
import com.jsms.java.model.State;
import com.jsms.java.model.VehicleType;


public interface DropDownService {
	List<State> getAllStates();
	List<District> getDistrictsById(int id);
	List<District> getSubDistrictsById(int id);
	List<Designation> getAllDesignations();
	List<VehicleType> getVehicleTypes();
	List<Caste> getAllCastes();
	List<Qualification> getAllQualifications();
	List<BloodGroups> getAllBloodGroups();
	List<BankDetails> getAllBanks();
	List<CardDetails> getAllCards();
	List<AddressIdProof> getAllIdProofs();
	List<AddressIdProof> getAllAddressProofs();
	List<Designation> getAllCaders();
}
