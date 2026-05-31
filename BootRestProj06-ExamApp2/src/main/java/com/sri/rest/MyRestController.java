package com.sri.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sri.model.Employee;

@RestController
public class MyRestController {

	@PutMapping("/emp")
	public ResponseEntity<Employee> show(@RequestBody Employee emp){
		return new ResponseEntity<Employee>(emp,HttpStatus.OK);
	}
}
