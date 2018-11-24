package com.jsms.java.dao;

import java.util.List;

import com.jsms.java.model.Agent;
import com.jsms.java.model.Customer;
import com.jsms.java.model.Designation;
import com.jsms.java.model.RestfulResponse;

public interface AgentDao {
	RestfulResponse saveAgent(Agent agent);
	List<Agent> getAllAgents();
	List<Customer> getAllCustomersByAgentId(String agentId);
	Agent getAgentById(String agentId);
	List<Agent> getAgentsByCaderId(int caderId);
	List<Agent> getAgentTreeById(String agentCode);
	List<Designation> getAgentCadersById(int caderId);
	int getAgentCaderById(String agentCode);
}
