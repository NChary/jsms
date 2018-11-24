package com.jsms.java.dao;

import com.jsms.java.model.AgentDashboard;
import com.jsms.java.model.Dashboard;

public interface DashboardDao {
	Dashboard getAllDetails();
	AgentDashboard getAgentDashBoard(String agentCode);
}
