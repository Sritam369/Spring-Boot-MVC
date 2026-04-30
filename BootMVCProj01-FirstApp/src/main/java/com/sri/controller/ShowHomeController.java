package com.sri.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ShowHomeController {

//	@RequestMapping("/home")
//	public String showHome() {
//		return "Welcome"; // LVN
//	}
	
	// For trapping every request
	@RequestMapping(value={"/", "/home"})
	public String showHome() {
		return "Welcome"; // LVN
	}
}
