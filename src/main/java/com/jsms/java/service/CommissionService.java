package com.jsms.java.service;

import java.util.List;

import com.jsms.java.model.AgentCommission;

public interface CommissionService {
	List<AgentCommission> agetAllAgentsCommission();
	public List<AgentCommission> getAllAgentsCommission();
	List<AgentCommission> getCommissionByAgentId(String agentCode);
	
}
