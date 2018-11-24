package com.jsms.java.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsms.java.dao.BranchDao;
import com.jsms.java.model.Branch;
import com.jsms.java.model.RestfulResponse;
import com.jsms.java.service.BranchService;

@Service(value="branchService")
public class BranchServiceImpl implements BranchService{

	@Autowired
	private BranchDao branchDao;
	
	@Override
	public RestfulResponse saveBranch(Branch branch) {
		return branchDao.saveBranch(branch);
	}

	@Override
	public List<Branch> getAllBranches() {
		return branchDao.getAllBranches();
	}

	 
	
}
