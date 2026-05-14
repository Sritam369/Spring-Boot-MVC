package com.sri.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sri.entity.Employee;
import com.sri.repository.EmployeeRepo;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepo repo;

	@Override
	public List<Employee> selectEmp() {
		List<Employee> all = repo.findAll();
		return all;
	}

	@Override
	public String addEmp(Employee emp) {
		Employee save = repo.save(emp);
		return "Employee record saved with id : "+save.getEmpNo();
	}
	
	
}
