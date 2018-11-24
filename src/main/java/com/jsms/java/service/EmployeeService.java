package com.jsms.java.service;

import java.util.List;

import com.jsms.java.model.Employee;
import com.jsms.java.model.RestfulResponse;

public interface EmployeeService {
	RestfulResponse saveEmployee(Employee employee);
	List<Employee> getAllEmployees();
	Employee getEmployeeById(int empCode);
	List<Employee> findEmployeesByBranch(String branchCode);
}
