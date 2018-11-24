package com.jsms.java.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jsms.java.model.Employee;
import com.jsms.java.model.RestfulResponse;
import com.jsms.java.service.EmployeeService;

@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	 
	@RequestMapping(value = "/createemp", method = RequestMethod.POST,headers="Accept=application/json")
	public RestfulResponse createEmployee(@RequestBody Employee employee)
	{
		RestfulResponse restFulResponse = null;
		try{
			restFulResponse = employeeService.saveEmployee(employee);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return restFulResponse;
	}

	
	@RequestMapping(value = "/getallemp", method = RequestMethod.GET,headers="Accept=application/json")
	public List<Employee> getAllEmployees()
	{
		List<Employee> lstAllEmployees=null;
		try{
			lstAllEmployees = employeeService.getAllEmployees();
		}catch(Exception e){
			e.printStackTrace();
		}
		return lstAllEmployees;
	}
	
	@RequestMapping(value = "/getemployeebyid/{id}", method = RequestMethod.GET,headers="Accept=application/json")
	public Employee getEmployeeById(@PathVariable int id)
	{
		Employee employee=null;
		try{
			employee = employeeService.getEmployeeById(id);
		}catch(EmptyResultDataAccessException e){
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return employee;
	}
	
	
	@RequestMapping(value = "/getempbybranch/{branchCode}", method = RequestMethod.GET,headers="Accept=application/json")
	public List<Employee> findEmployeesByBranch(@PathVariable String branchCode)
	{
		List<Employee> lstAllEmployees=null;
		try{
			lstAllEmployees = employeeService.findEmployeesByBranch(branchCode);
		}catch(EmptyResultDataAccessException e){
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return lstAllEmployees;
	}
}
