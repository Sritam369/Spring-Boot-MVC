package com.sri.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.sri.model.Student;

@Controller
public class MyController {

	@GetMapping("/")
	public String home() {
		return "home";
	}
	
	@GetMapping("/form")
	public String showForm(@ModelAttribute("stud") Student st) {
		return "form";
	}
	
	@PostMapping("/register")
	public String registerForm(Map<String,Object>map, @ModelAttribute("stud") Student st) {
		map.put("StudentData", st);		
		return "show";
	}
}
