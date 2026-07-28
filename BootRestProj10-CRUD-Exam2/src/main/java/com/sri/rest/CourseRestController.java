package com.sri.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sri.entity.Job;
import com.sri.service.JobService;

@RestController
public class CourseRestController {

	@Autowired
	private JobService service;
	
	@PostMapping("/add")
	public ResponseEntity<String> add(@RequestBody Job c){
		String course = service.addCourse(c);
		return new ResponseEntity<String>(course,HttpStatus.OK);
	}
	
	@GetMapping("/view")
	public ResponseEntity<List<Job>> view(){
		 List<Job> view = service.viewAll();
		return new ResponseEntity <List<Job>>(view,HttpStatus.OK);
	}
	
	@GetMapping("/viewById/{id}")
	public ResponseEntity<Job> viewById(@PathVariable Integer id){
		Job view = service.viewById(id);
		return new ResponseEntity <Job>(view,HttpStatus.OK);
	}
	
	@PutMapping("/update")
	public ResponseEntity<String> update(@RequestBody Job c){
		String update = service.update(c);
		return new ResponseEntity <String>(update,HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> delete(@PathVariable Integer id){
		String delete = service.delete(id);
		return new ResponseEntity <String>(delete,HttpStatus.OK);
	}
}
