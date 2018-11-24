package com.jsms.java.service;

import java.util.List;

import com.jsms.java.model.Agent;
import com.jsms.java.model.Customer;
import com.jsms.java.model.Designation;
import com.jsms.java.model.RestfulResponse;

public interface AgentService {
	RestfulResponse saveAgent(Agent agent);
	List<Customer> getAllCustomersByAgentId(String agentId);
	List<Agent> agetAllAgents();
	Agent getAgentById(String agentId);
	List<Agent> getAgentsByCaderId(int caderId);
	List<Agent> getAgentTreeById(String agentCode);
	List<Designation> getAgentCadersById(String agentCode);
}
