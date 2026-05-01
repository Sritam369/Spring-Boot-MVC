package com.sri.controller;

import java.time.LocalDate;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyController {
/*
	@RequestMapping("/")
	public String showData(Map<String,Object>map) {
		map.put("date", LocalDate.now());
		map.put("age", 18);
		return "show";
	}*/
	
	// For forwarding data to another handler method
	
	/*@RequestMapping("/")
	public String showData(Map<String,Object>map) {
		map.put("date", LocalDate.now());
		map.put("age", 18);
		return "forward:process";
	}
	
	@RequestMapping("/process")
	public String showData() {
		return "show";
	}*/
	
	// For redirecting
	@RequestMapping("/")
	public String showData(Map<String,Object>map) {
		map.put("date", LocalDate.now());
		map.put("age", 18);
		return "redirect:process";
	}
	
	@RequestMapping("/process")
	public String showData() {
		return "show";
	}
	
}
