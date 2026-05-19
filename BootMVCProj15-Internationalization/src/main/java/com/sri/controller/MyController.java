package com.sri.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.sti.model.Customer;

@Controller
public class MyController {

	@GetMapping("/")
	public String showHome() {
		return "home";
	}
	@GetMapping("/register")
	public String showFormPage(@ModelAttribute("cust")Customer c) {	
		return "form";
	}
}
