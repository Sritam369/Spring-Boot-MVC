package com.sri.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sri.entity.Employee;
import com.sri.repository.EmpRepo;

@Service
public class EmpService {

	@Autowired
	private EmpRepo repo;
	
	public String add(Employee e) {
		Employee emp = repo.save(e);
		return "Employee added with empId "+emp.getEmp_id();
	}
	
	public Employee show(Integer id) {
		Employee byId = repo.findById(id).orElseThrow(()-> new RuntimeException("message : Employee Not Found"));
		return byId; 
	}
}
