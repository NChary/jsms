package com.jsms.java.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsms.java.dao.DropDownDao;
import com.jsms.java.dao.StatesDao;
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
import com.jsms.java.service.DropDownService;

@Service(value="dropdownService")
public class DropDownServiceImpl implements DropDownService{

	@Autowired
	private StatesDao statesDao;

	@Autowired
	private DropDownDao dropDownDao;


	@Override
	public List<State> getAllStates() {
		return statesDao.getAllStates();
	}

	@Override
	public List<District> getDistrictsById(int id) {
		return statesDao.getDistrictsById(id);
	}

	@Override
	public List<District> getSubDistrictsById(int id) {
		return statesDao.getSubDistrictsById(id);
	}

	@Override
	public List<Designation> getAllDesignations() {
		return dropDownDao.getAllDesignations();
	}

	@Override
	public List<VehicleType> getVehicleTypes() {
		return dropDownDao.getVehicleType();
	}

	@Override
	public List<Caste> getAllCastes() {
		return dropDownDao.getAllCastes();
	}

	@Override
	public List<Qualification> getAllQualifications() {
		return dropDownDao.getAllQualifications();
	}

	@Override
	public List<BloodGroups> getAllBloodGroups() {
		return dropDownDao.getAllBloodGroups();
	}

	@Override
	public List<BankDetails> getAllBanks() {
		return dropDownDao.getAllBanks();
	}

	@Override
	public List<CardDetails> getAllCards() {
		return dropDownDao.getAllCardDetails();
	}

	@Override
	public List<AddressIdProof> getAllIdProofs() {
		return dropDownDao.getAllIdProofs();
	}

	@Override
	public List<AddressIdProof> getAllAddressProofs() {
		return dropDownDao.getAllAddressProofs();
	}

	@Override
	public List<Designation> getAllCaders() {
		return dropDownDao.getAllCaders();
	}

}
