package com.jsms.java.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsms.java.dao.CommissionDao;
import com.jsms.java.model.AgentCommission;
import com.jsms.java.service.CommissionService;

@Service(value="commissionService")
public class CommissionServiceImpl implements CommissionService{

	@Autowired
	private CommissionDao commissionDao;

	@Override
	public List<AgentCommission> agetAllAgentsCommission() {
		return commissionDao.getAllAgentsCommission();
	}

	@Override
	public List<AgentCommission> getCommissionByAgentId(String agentCode) {
		return commissionDao.getCommissionByAgentId(agentCode);
	}

	@Override
	public List<AgentCommission> getAllAgentsCommission() {
		// TODO Auto-generated method stub
		return null;
	}


}
