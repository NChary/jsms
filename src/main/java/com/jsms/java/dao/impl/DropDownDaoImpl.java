package com.jsms.java.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.jsms.java.constants.JsfsTables;
import com.jsms.java.dao.DropDownDao;
import com.jsms.java.model.AddressIdProof;
import com.jsms.java.model.BankDetails;
import com.jsms.java.model.BloodGroups;
import com.jsms.java.model.CardDetails;
import com.jsms.java.model.Caste;
import com.jsms.java.model.Designation;
import com.jsms.java.model.Qualification;
import com.jsms.java.model.VehicleType;

@Repository(value="dropdowndao")
public class DropDownDaoImpl implements DropDownDao{

	 @Autowired
	 private JdbcTemplate jdbcTemplate;
	 
	 
	 public JdbcTemplate getJdbcTemplate() {
	        return jdbcTemplate;
	 }
	
	@Override
	public List<Designation> getAllDesignations() {
		String sql = "select * from "+JsfsTables.DESIGNATIONS;
		List<Designation> employees = getJdbcTemplate().query(sql,new BeanPropertyRowMapper(Designation.class));
		return employees;
	}

	@Override
	public List<VehicleType> getVehicleType() {
		String sql = "select * from "+JsfsTables.VEHICLETYPE;
		List<VehicleType> vehicleTypes = getJdbcTemplate().query(sql,new BeanPropertyRowMapper(VehicleType.class));
		return vehicleTypes;
	}

	@Override
	public List<Caste> getAllCastes() {
		String sql = "select * from "+JsfsTables.CASTE;
		List<Caste> vehicleTypes = getJdbcTemplate().query(sql,new BeanPropertyRowMapper(Caste.class));
		return vehicleTypes;
	}

	@Override
	public List<Qualification> getAllQualifications() {
		String sql = "select * from "+JsfsTables.QUALIFICATION;
		List<Qualification> qualification = getJdbcTemplate().query(sql,new BeanPropertyRowMapper(Qualification.class));
		return qualification;
	}

	@Override
	public List<BloodGroups> getAllBloodGroups() {
		String sql = "select * from "+JsfsTables.BLOODGROUPS;
		List<BloodGroups> bloodGroups = getJdbcTemplate().query(sql,new BeanPropertyRowMapper(BloodGroups.class));
		return bloodGroups;
	}

	@Override
	public List<BankDetails> getAllBanks() {
		String sql = "select * from "+JsfsTables.BANK_DETAILS;
		List<BankDetails> bankDetails = getJdbcTemplate().query(sql,new BeanPropertyRowMapper(BankDetails.class));
		return bankDetails;
	}

	@Override
	public List<CardDetails> getAllCardDetails() {
		String sql = "select * from "+JsfsTables.CARD_DETAILS+" where status=0";
		List<CardDetails> cardDetails = getJdbcTemplate().query(sql,new BeanPropertyRowMapper(CardDetails.class));
		return cardDetails;
	}

	@Override
	public List<AddressIdProof> getAllIdProofs() {
		String sql = "select * from "+JsfsTables.IDPROOF;
		List<AddressIdProof> idProof = getJdbcTemplate().query(sql,new BeanPropertyRowMapper(AddressIdProof.class));
		return idProof;
	}

	@Override
	public List<AddressIdProof> getAllAddressProofs() {
		String sql = "select * from "+JsfsTables.ADDRESSPROOF;
		List<AddressIdProof> addressIDProof = getJdbcTemplate().query(sql,new BeanPropertyRowMapper(AddressIdProof.class));
		return addressIDProof;
	}

	@Override
	public List<Designation> getAllCaders() {
		String sql = "select * from "+JsfsTables.CADERS+" where status=1";
		List<Designation> employees = getJdbcTemplate().query(sql,new BeanPropertyRowMapper(Designation.class));
		return employees;
	}
	
	
}
