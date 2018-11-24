package com.jsms.java.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jsms.java.model.Dashboard;
import com.jsms.java.service.DashboardService;

@RestController
public class DashboardController {

	@Autowired
	private DashboardService dashboardService;
	 

	@RequestMapping(value = "/getdashboard", method = RequestMethod.GET,headers="Accept=application/json")
	public Dashboard getAllAgents()
	{
		Dashboard dashboard = null;
		
		try{
			dashboard = dashboardService.getAllDetails();
		}catch(Exception e){
			e.printStackTrace();
		}
		return dashboard;
	}


	@RequestMapping(value = "/getagentdashboard", method = RequestMethod.GET,headers="Accept=application/json")
	public Dashboard getAgentDashBoard()
	{
		Dashboard dashboard = null;
		
		try{
			dashboard = dashboardService.getAllDetails();
		}catch(Exception e){
			e.printStackTrace();
		}
		return dashboard;
	}

	
	
}
