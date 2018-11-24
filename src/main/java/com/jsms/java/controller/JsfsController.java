package com.jsms.java.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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

@RestController
public class JsfsController {

	@Autowired
	private DropDownService dropDownService;

	@RequestMapping(value = "/getallstates", method = RequestMethod.GET,headers="Accept=application/json")
	public List<State> getAllStates()
	{
		List<State> states=null;
		try{
			states = dropDownService.getAllStates();
		}catch(Exception e){
			e.printStackTrace();
		}

		return states;
	}


	@RequestMapping(value="/getdistrict/{id}",method=RequestMethod.GET,headers="Accept=application/json")
	public List<District> getAllDistricts(@PathVariable int id)
	{
		List<District> districts=null;

		try{
			districts = dropDownService.getDistrictsById(id);
		}catch(Exception e){
			e.printStackTrace();
		}
		return districts;
	}


	@RequestMapping(value="/getsubdistrict/{id}",method=RequestMethod.GET,headers="Accept=application/json")
	public List<District> getAllSubDistricts(@PathVariable int id)
	{
		List<District> districts=null;

		try{
			districts = dropDownService.getSubDistrictsById(id);
		}catch(Exception e){
			e.printStackTrace();
		}
		return districts;
	}


	@RequestMapping(value="/getdesignations",method=RequestMethod.GET,headers="Accept=application/json")
	public List<Designation> getAllDesignations()
	{
		List<Designation> designations = null;

		try{
			designations = dropDownService.getAllDesignations();
		}catch(Exception e){
			e.printStackTrace();
		}
		return designations;
	}

	@RequestMapping(value="/getcaders",method=RequestMethod.GET,headers="Accept=application/json")
	public List<Designation> getAllCaders()
	{
		List<Designation> designations = null;

		try{
			designations = dropDownService.getAllCaders();
		}catch(Exception e){
			e.printStackTrace();
		}
		return designations;
	}

	
	@RequestMapping(value="/getvehicletypes",method=RequestMethod.GET,headers="Accept=application/json")
	public List<VehicleType> getVehicleTypes()
	{
		List<VehicleType> designations = null;

		try{
			designations = dropDownService.getVehicleTypes();
		}catch(Exception e){
			e.printStackTrace();
		}
		return designations;
	}

	@RequestMapping(value="/getallcastes",method=RequestMethod.GET,headers="Accept=application/json")
	public List<Caste> getAllCastes()
	{
		List<Caste> castes = null;

		try{
			castes = dropDownService.getAllCastes();
		}catch(Exception e){
			e.printStackTrace();
		}
		return castes;
	}


	@RequestMapping(value="/getallqualification",method=RequestMethod.GET,headers="Accept=application/json")
	public List<Qualification> getAllQualifications()
	{
		List<Qualification> castes = null;

		try{
			castes = dropDownService.getAllQualifications();
		}catch(Exception e){
			e.printStackTrace();
		}
		return castes;
	}

	@RequestMapping(value="/getallbloodgroups",method=RequestMethod.GET,headers="Accept=application/json")
	public List<BloodGroups> getAllBloodGroups()
	{
		List<BloodGroups> bloodGroups = null;

		try{
			bloodGroups = dropDownService.getAllBloodGroups();
		}catch(Exception e){
			e.printStackTrace();
		}
		return bloodGroups;
	}

	@RequestMapping(value="/getallbanks",method=RequestMethod.GET,headers="Accept=application/json")
	public List<BankDetails> getAllBanks(){
		List<BankDetails> lstBanks = null;
		try{
			lstBanks = dropDownService.getAllBanks();
		}catch(Exception e){
			e.printStackTrace();
		}
		return lstBanks;
	}
	

	@RequestMapping(value="/getallcards",method=RequestMethod.GET,headers="Accept=application/json")
	public List<CardDetails> getAllCardDetails(){
		List<CardDetails> lstCardDetails = null;
		try{
			lstCardDetails = dropDownService.getAllCards();
		}catch(Exception e){
			e.printStackTrace();
		}
		return lstCardDetails;
	}

	@RequestMapping(value="/getallidproofs",method=RequestMethod.GET,headers="Accept=application/json")
	public List<AddressIdProof> getAllIdProofs(){
		List<AddressIdProof> lstIdProofs = null;
		try{
			lstIdProofs = dropDownService.getAllIdProofs();
		}catch(Exception e){
			e.printStackTrace();
		}
		return lstIdProofs;
	}
	
	
	@RequestMapping(value="/getalladdressproofs",method=RequestMethod.GET,headers="Accept=application/json")
	public List<AddressIdProof> getAllAddressProofs(){
		List<AddressIdProof> lstAddressProofs = null;
		try{
			lstAddressProofs = dropDownService.getAllAddressProofs();
		}catch(Exception e){
			e.printStackTrace();
		}
		return lstAddressProofs;
	}

	// Save Error Log
	
}
