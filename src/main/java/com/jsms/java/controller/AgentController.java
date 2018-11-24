package com.jsms.java.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jsms.java.constants.JsfsLiterals;
import com.jsms.java.model.Agent;
import com.jsms.java.model.Customer;
import com.jsms.java.model.Designation;
import com.jsms.java.model.RestfulResponse;
import com.jsms.java.service.AgentService;
import com.jsms.java.service.restexception.RestException;

@RestController
public class AgentController {
	
	
	@Autowired
	private AgentService agentService;
	 
	@RequestMapping(value = "/createagent", method = RequestMethod.POST,headers="Accept=application/json")
	public RestfulResponse createEmployee(@RequestBody Agent agent)
	{
		RestfulResponse restFullResponse=null;
		try{
			if(agent!=null){
				restFullResponse = agentService.saveAgent(agent);
			}else{
				restFullResponse = new RestfulResponse();
				restFullResponse.setCode("");
				restFullResponse.setMessage(JsfsLiterals.AGENT_FAIL);
			}
		}catch(Exception e){
			restFullResponse = new RestfulResponse();
			restFullResponse.setCode("");
			restFullResponse.setMessage(JsfsLiterals.AGENT_FAIL);
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
	}
	
	@RequestMapping(value = "/getagentsbycaderid/{id}", method = RequestMethod.GET,headers="Accept=application/json")
	public List<Agent> getAgentsByCaderId(@PathVariable int id)
	{
		List<Agent> lstAgents=null;
		try{
			lstAgents = agentService.getAgentsByCaderId(id);
		}catch(Exception e){
			e.printStackTrace();
		}
		return lstAgents;
	}
	
	
	@RequestMapping(value = "/getcustbyagentid/{agentId}", method = RequestMethod.GET,headers="Accept=application/json")
	public List<Customer> getAllCustomersByAgentId(@PathVariable String agentId)
	{
		List<Customer> lstCustomers=null;
		try{
			lstCustomers = agentService.getAllCustomersByAgentId(agentId);
		}catch(Exception e){
			e.printStackTrace();
		}
		return lstCustomers;
	}
	
	@RequestMapping(value = "/getagentbyid/{id}", method = RequestMethod.GET,headers="Accept=application/json")
	public Agent getAgentById(@PathVariable String id)
	{
		Agent agent=null;
		try{
			agent = agentService.getAgentById(id);
		}catch(Exception e){
			e.printStackTrace();
			throw new RestException(JsfsLiterals.FETCH_AGENT_CODE, JsfsLiterals.FETCH_AGENT_DETAILS);
		}
		return agent;
	}
	
	@RequestMapping(value = "/getagenttreebyid/{id}", method = RequestMethod.GET,headers="Accept=application/json")
	public List<Agent> getAgentTreeById(@PathVariable String id)
	{
		List<Agent> lstAgentsTree=null;
		try{
			lstAgentsTree = agentService.getAgentTreeById(id);
		}catch(Exception e){
			e.printStackTrace();
			throw new RestException(JsfsLiterals.FETCH_AGENT_CODE, JsfsLiterals.FETCH_AGENT_DETAILS);
		}
		return lstAgentsTree;
	}
	
	
	@RequestMapping(value = "/getagentcaders/{id}", method = RequestMethod.GET,headers="Accept=application/json")
	public List<Designation> getAgentCaders(@PathVariable String id)
	{
		List<Designation> lstAgentsTree=null;
		try{
			lstAgentsTree = agentService.getAgentCadersById(id);
		}catch(EmptyResultDataAccessException e){
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return lstAgentsTree;
	}
}
