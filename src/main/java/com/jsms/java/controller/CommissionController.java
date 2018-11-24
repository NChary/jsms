package com.jsms.java.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jsms.java.model.AgentCommission;
import com.jsms.java.service.CommissionService;

@RestController
public class CommissionController {
	
	@Autowired
	private CommissionService commissionService;
	
	
	@RequestMapping(value = "/getagentscommission", method = RequestMethod.GET,headers="Accept=application/json")
	public List<AgentCommission> getAgentsCommssion()
	{
		List<AgentCommission> lstCommissions=null;
		try{
			lstCommissions = commissionService.agetAllAgentsCommission();
		}catch(Exception e){
			e.printStackTrace();
		}
		return lstCommissions;
	}
	
	
	@RequestMapping(value = "/getagentscommissionbyid/{id}", method = RequestMethod.GET,headers="Accept=application/json")
	public List<AgentCommission> getAgentsCommssionById(@PathVariable String id)
	{
		List<AgentCommission> lstCommissions=null;
		try{
			lstCommissions = commissionService.getCommissionByAgentId(id);
		}catch(Exception e){
			e.printStackTrace();
		}
		return lstCommissions;
	}
	 
	/*@RequestMapping(value = "/createagent", method = RequestMethod.POST,headers="Accept=application/json")
	public RestfulResponse createEmployee(@RequestBody Agent agent)
	{
		RestfulResponse restFullResponse=null;
		try{
			restFullResponse = agentService.saveAgent(agent);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return restFullResponse;
	}

	@RequestMapping(value = "/getallagents", method = RequestMethod.GET,headers="Accept=application/json")
	public List<Agent> getAllAgents()
	{
		List<Agent> lstAgents=null;
		try{
			lstAgents = agentService.agetAllAgents();
		}catch(Exception e){
			e.printStackTrace();
		}
		return lstAgents;
	}*/
	
		
}
