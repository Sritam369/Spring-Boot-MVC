package com.sri.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sri.entity.Employee;
import com.sri.service.EmpService;

@RestController
@RequestMapping("/rest")
public class EmployeeRestApi {

	@Autowired
	private EmpService service;
	
	@PostMapping("/insert")
	public ResponseEntity<String> add(@RequestBody Employee e){
		String msg = service.add(e);
		return new ResponseEntity<>(msg,HttpStatus.OK);
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<Employee> show(@PathVariable(name="id") Integer id){
		Employee emp = service.show(id);
		return ResponseEntity.ok(emp);		
	}
}
