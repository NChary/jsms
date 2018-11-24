package com.jsms.java.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.jsms.java.constants.JsfsTables;
import com.jsms.java.dao.CommissionDao;
import com.jsms.java.model.AgentCommission;
import com.jsms.java.model.ErrorLog;
import com.jsms.java.util.IdGeneratorUtil;
import com.jsms.java.util.ImageUploadUtil;
import com.jsms.java.util.SMSHelper;

@Repository(value="commissionDao")
public class CommissionDaoImpl implements CommissionDao{

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Autowired
	private SMSHelper smsHelper;
	
	@Autowired
	private ImageUploadUtil imageUploadUtil;


	@Autowired
	private IdGeneratorUtil idGeneratorUtil;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	@Override
	public List<AgentCommission> getAllAgentsCommission() {
		String sql = "select * from "+JsfsTables.AGENT_COMMISSION+" where status=0";
		List<AgentCommission> agentCommissions = getJdbcTemplate().query(sql,new BeanPropertyRowMapper(AgentCommission.class));
		return agentCommissions;
	}

	@Override
	public List<AgentCommission> getCommissionByAgentId(String agentCode) {
		String sql = "select * from "+JsfsTables.AGENT_COMMISSION+" where agentCode = "+agentCode;
		List<AgentCommission> agentCommissions = getJdbcTemplate().query(sql,new BeanPropertyRowMapper(AgentCommission.class));
		return agentCommissions;
	}

	@Override
	public void saveErrorLog(ErrorLog errorLog) {
		// TODO Auto-generated method stub
		
	}



}
