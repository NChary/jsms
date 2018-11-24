package com.jsms.java.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.jsms.java.dao.AgentBankDetailsDao;
import com.jsms.java.model.BankDetails;


@Repository(value="agentDao1")
public class AgentBankDetailsDaoImpl implements AgentBankDetailsDao{

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	/*@Override
	public String saveAgentBankDetails(BankDetails bankDetails) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String saveAgentBankDetails(BankDetails bankDetails) {
		// TODO Auto-generated method stub
		return null;
	}*/

	@Override
	public String saveAgentBankDetails(BankDetails bankDetails) {
		// TODO Auto-generated method stub
		return null;
	}



 
}
