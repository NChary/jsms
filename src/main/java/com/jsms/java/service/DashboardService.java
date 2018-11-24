package com.jsms.java.service;

import com.jsms.java.model.AgentDashboard;
import com.jsms.java.model.Dashboard;

public interface DashboardService {
	Dashboard getAllDetails();
	AgentDashboard getAgentDashBoard(String agentCode);
}
