package com.jsms.java.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.jsms.java.constants.JsfsLiterals;
import com.jsms.java.constants.JsfsTables;
import com.jsms.java.dao.BranchDao;
import com.jsms.java.model.Branch;
import com.jsms.java.model.RestfulResponse;

@Repository(value="branchDao")
public class BranchDaoImpl implements BranchDao{



	@Autowired
	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}


	@Override
	public RestfulResponse saveBranch(Branch branch) {
		RestfulResponse restfulResponse = new RestfulResponse();
		int pk = getLastRecPk();
		branch.setBranchCode(getBranchCode(pk));
		branch.setStatus(1);
		String insertSql = "insert into "+JsfsTables.BRANCH+"  values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
		int res = jdbcTemplate.update(insertSql,new Object[]{branch.getId(),branch.getBranchCode(),branch.getBranchName(),branch.getCreatedBy(),branch.getCreatedDate(),
				branch.getUpdatedBy(),branch.getUpdateDate(),branch.getStatus(),branch.getDistrictId(),branch.getStateId(),branch.getContactNumber(),
				branch.getAddress(),branch.getTalukaId()});

		if(res == 1)
		{
			restfulResponse.setCode(branch.getBranchCode());
			restfulResponse.setMessage(JsfsLiterals.CREATE_BRANCH_SUCCESS);
			restfulResponse.setStatus(JsfsLiterals.RESPONSE_SUCCESS);
		}else{
			restfulResponse.setCode(null);
			restfulResponse.setMessage(JsfsLiterals.CREATE_BRANCH_FAIL);
			restfulResponse.setStatus(JsfsLiterals.RESPONSE_SUCCESS);
		}

		System.out.println("BranchDAO = "+res);
		return restfulResponse;
	}


	public int getLastRecPk(){

		String sql1 = "select count(*) from "+JsfsTables.BRANCH ;
		int branchCount = getJdbcTemplate().queryForInt(sql1);
		if(branchCount>0){
			String sql = "select * from "+JsfsTables.BRANCH+" order by 7 desc limit 1";
			Branch branch = (Branch)getJdbcTemplate().queryForObject(sql,new BeanPropertyRowMapper(Branch.class));
			return branch.getId();
		}else{
			return 1;
		}
	}

	@Override
	public List<Branch> getAllBranches() {

		String sql = "select * from "+JsfsTables.BRANCH;
		List<Branch> districts = getJdbcTemplate().query(sql,new BeanPropertyRowMapper(Branch.class));
		return districts;
	}

	public String getBranchCode(int pk)
	{
		String prefix = "";
		if(pk<10){
			prefix = JsfsLiterals.BRANCH_PREFIX+"00";
		}else if(pk<100){
			prefix = JsfsLiterals.BRANCH_PREFIX+"0";
		}
		String branchCode = prefix +pk;
		System.out.println("BRANCH Code = "+branchCode+" \t "+pk);
		return branchCode;
	}



}
