package com.jsms.java.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsms.java.dao.AgentDao;
import com.jsms.java.model.Agent;
import com.jsms.java.model.Customer;
import com.jsms.java.model.Designation;
import com.jsms.java.model.RestfulResponse;
import com.jsms.java.service.AgentService;

@Service(value="agentService")
public class AgentServiceImpl implements AgentService{

	@Autowired
	private AgentDao agentDao;
	
	 
	@Override
	public RestfulResponse saveAgent(Agent agent) {
		return agentDao.saveAgent(agent);
	}


	@Override
	public List<Customer> getAllCustomersByAgentId(String agentId) {
		return agentDao.getAllCustomersByAgentId(agentId);
	}


	@Override
	public Agent getAgentById(String agentId) {
		return agentDao.getAgentById(agentId);
	}


	@Override
	public List<Agent> agetAllAgents() {
		return agentDao.getAllAgents();
	}


	@Override
	public List<Agent> getAgentsByCaderId(int caderId) {
		return agentDao.getAgentsByCaderId(caderId);
	}


	@Override
	public List<Agent> getAgentTreeById(String agentCode) {
		return agentDao.getAgentTreeById(agentCode);
	}


	@Override
	public List<Designation> getAgentCadersById(String agentCode) {
		int cader = agentDao.getAgentCaderById(agentCode);
		List<Designation> lst=null;
		if(cader>0){
			lst = agentDao.getAgentCadersById(cader);
		}
		return lst;
	}



}
