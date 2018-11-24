package com.jsms.java.dao;

import java.util.List;

import com.jsms.java.model.AgentCommission;
import com.jsms.java.model.ErrorLog;

public interface CommissionDao {
	void saveErrorLog(ErrorLog errorLog);
	List<AgentCommission> getAllAgentsCommission();
	List<AgentCommission> getCommissionByAgentId(String agentCode);
}
