package com.jsms.java.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsms.java.dao.DashboardDao;
import com.jsms.java.model.AgentDashboard;
import com.jsms.java.model.Dashboard;
import com.jsms.java.service.DashboardService;
@Service(value="dashboardservice")
public class DashboardServiceImpl implements DashboardService{

	@Autowired
	private DashboardDao dashboardDao;

	@Override
	public Dashboard getAllDetails() {
		return dashboardDao.getAllDetails();
	}

	@Override
	public AgentDashboard getAgentDashBoard(String agentCode) {
		return dashboardDao.getAgentDashBoard(agentCode);
	}
	
	
	
}
