package com.sri.service;

import java.util.List;

import com.sri.entity.Employee;

public interface EmployeeService {

	List<Employee> selectEmp();
	String addEmp(Employee emp);
}
