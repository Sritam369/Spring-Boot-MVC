package com.sri.controller;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.sri.model.Employee;

@Controller
public class MyController {

	@GetMapping("/")
	public String show(Map<String,Object> map) {
		List<Employee> empList = List.of(new Employee(101,"sritam",70000.0),new Employee(102,"subrat",65000.0));
		map.put("empData", empList);
		return "show";
	}
}
