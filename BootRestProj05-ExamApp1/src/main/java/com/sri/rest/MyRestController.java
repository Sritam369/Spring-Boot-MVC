package com.sri.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sri.model.Student;

@RestController
public class MyRestController {

	@GetMapping("/stud")
	public ResponseEntity<Student> show(){
		Student s = new Student(101,"sritam","java",30000.0);
		return new ResponseEntity<Student>(s,HttpStatus.OK);
	}
}
