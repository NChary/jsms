package com.jsms.java.dao;

import java.util.List;

import com.jsms.java.model.Employee;
import com.jsms.java.model.RestfulResponse;

public interface EmployeeDao {
	RestfulResponse saveEmployee(Employee employee);
	List<Employee> getAllEmployees();
	Employee getEmployeeById(int empCode);
	RestfulResponse updateEmployee(Employee employee);
	List<Employee> findEmployeesByBranch(String branchCode);
}
