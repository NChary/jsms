package com.jsms.java.service;

import java.util.List;

import com.jsms.java.model.Branch;
import com.jsms.java.model.RestfulResponse;

public interface BranchService {
	RestfulResponse saveBranch(Branch branch);
	List<Branch> getAllBranches();
}
