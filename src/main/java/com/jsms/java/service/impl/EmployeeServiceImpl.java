package com.jsms.java.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsms.java.dao.EmployeeDao;
import com.jsms.java.model.Employee;
import com.jsms.java.model.RestfulResponse;
import com.jsms.java.service.EmployeeService;

@Service(value="employeeService")
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	private EmployeeDao employeeDao;
	
	@Override
	public RestfulResponse saveEmployee(Employee employee) {
		return employeeDao.saveEmployee(employee);
	}

	@Override
	public List<Employee> getAllEmployees() {
		return employeeDao.getAllEmployees();
	}

	@Override
	public Employee getEmployeeById(int empCode) {
		return employeeDao.getEmployeeById(empCode);
	}

	@Override
	public List<Employee> findEmployeesByBranch(String branchCode) {
		return employeeDao.findEmployeesByBranch(branchCode);
	}

}
