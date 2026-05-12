package com.sri.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sri.model.Course;

@Controller
public class CourseController {

	@GetMapping("/")
	public String showHome() {
		return "home";
	}
	
	@GetMapping("/form")
	public String showForm() {
		return "form";
	}
	
	@PostMapping("/submit")
	public String showResult(Map<String,Object> map, @RequestParam(name="id",required=false) Integer courseId , @RequestParam(name="courseName",required=false) List<String> courseName ) {
		
		Course c =new Course();
		c.setCourseId(courseId);
		
		Map<String,Double> fees = new HashMap<>();
		fees.put("java", 3000.0);
		fees.put("python", 3000.0);
		fees.put("springboot", 4000.0);
		fees.put("datascience", 3500.0);
		
		List<String> courses = new ArrayList<>();
		Double sum = 0.0;
		for(String course:courseName) {
			Double fee = fees.get(course);
			courses.add(course + " (₹" + fee + ")");
			sum+=fee;
		}
		
		
		map.put("courses", courses);
		map.put("total", sum);
		return "result";
	}
}
