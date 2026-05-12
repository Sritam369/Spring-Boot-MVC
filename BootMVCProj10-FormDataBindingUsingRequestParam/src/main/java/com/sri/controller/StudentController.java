package com.sri.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sri.model.Student;

@Controller
public class StudentController {

	@GetMapping("/")
	public String showHome() {
		return "home";
	}
	@GetMapping("/form")
	public String showFormPage() {
		return "form";
	}
	
	@PostMapping("/submit")
	public String showResult(@RequestParam(name="rollNo",required=false, defaultValue = "122") int rollNo,@RequestParam(name="name",required=false, defaultValue = "sri") String name,@RequestParam(name="mark",required=false, defaultValue = "0") int mark, Map<String,Object>map) {
		map.put("roll", rollNo);
		map.put("name", name);
		map.put("mark", mark);
		return "result";
	}
}
