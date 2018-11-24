package com.jsms.java.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.jsms.java.constants.JsfsTables;
import com.jsms.java.dao.DashboardDao;
import com.jsms.java.model.AgentDashboard;
import com.jsms.java.model.Dashboard;
@Repository(value="dashboardDao")
public class DashboardDaoImpl implements DashboardDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
	
	@Override
	public Dashboard getAllDetails() {
		
		String sql = "select count(*) from "+JsfsTables.BRANCH;
		int branchCount = getJdbcTemplate().queryForInt(sql);

		String sql1 = "select count(*) from "+JsfsTables.EMPLOYEE_DETAILS;
		int empCount = getJdbcTemplate().queryForInt(sql1);

		String sql2 = "select count(*) from "+JsfsTables.AGENT_PERSONAL_DETAILS+" where status=1";
		int agentCount = getJdbcTemplate().queryForInt(sql2);

		String sql3 = "select count(*) from "+JsfsTables.CUSTOMER_PERSONAL_DETAILS+"";
		int custCount = getJdbcTemplate().queryForInt(sql3);

		Dashboard dashboard = new Dashboard();
		dashboard.setNoofBranches(branchCount);
		dashboard.setNoofEmployees(empCount);
		dashboard.setNoofAgents(agentCount);
		dashboard.setNoofCustomers(custCount);
		
		return dashboard;
	}

	@Override
	public AgentDashboard getAgentDashBoard(String agentCode) {
		// TODO Auto-generated method stub
		return null;
	}

}
