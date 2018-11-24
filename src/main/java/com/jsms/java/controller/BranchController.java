package com.jsms.java.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jsms.java.model.Branch;
import com.jsms.java.model.RestfulResponse;
import com.jsms.java.service.BranchService;

@RestController
public class BranchController {

	@Autowired
	private BranchService branchService;
	
	
	@RequestMapping(value = "/createbranch", method = RequestMethod.POST,headers="Accept=application/json")
	public RestfulResponse createEmployee(@RequestBody Branch branch)
	{
		RestfulResponse restFullResponse = null;
		try{
			restFullResponse = branchService.saveBranch(branch);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return restFullResponse;
	}

	@RequestMapping(value = "/getallbranches", method=RequestMethod.GET,headers="Accept=application/json")
	public List<Branch> getAllBranches(){
		List<Branch> lstBranches=null;
		try{
			lstBranches = branchService.getAllBranches();
		}catch(Exception e){
			e.printStackTrace();
		}
		return lstBranches;
	}
	
	
}
