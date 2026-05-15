package com.sri.service;

import java.util.List;
import java.util.Optional;

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

	@Override
	public Employee findId(Integer id) {
		Optional<Employee> byId = repo.findById(id);
		if(byId.isEmpty()) {
			throw new RuntimeException("invalid id");
		}
		return byId.get();
	}

	@Override
	public String update(Employee emp) {
		
			Employee save = repo.save(emp);
			return "Employee with id : "+save.getEmpNo()+" successfully updated";
			
		}

	@Override
	public String delete(Integer id) {
		Employee emp = repo.findById(id).orElseThrow(()-> new RuntimeException("Id not found"));
		repo.delete(emp);
		return "Employee with id : "+emp.getEmpNo()+" deleted successfully";
	}
	
}
