package com.jsms.java.dao;

import java.util.List;

import com.jsms.java.model.Branch;
import com.jsms.java.model.RestfulResponse;

public interface BranchDao {
	RestfulResponse saveBranch(Branch branch);
	List<Branch> getAllBranches();
}
