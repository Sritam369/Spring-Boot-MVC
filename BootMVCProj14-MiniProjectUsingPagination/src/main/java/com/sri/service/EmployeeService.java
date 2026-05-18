package com.sri.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.sri.entity.Employee;

public interface EmployeeService {

	Page<Employee> showEmpDataInPage(Pageable pageable);
	String addEmp(Employee emp);
	Employee findId(Integer id);
	String update(Employee emp);
	String delete(Integer id);
}
