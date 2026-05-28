package com.sri.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sri.model.Customer;

@RestController
public class MyController {

	@PostMapping("/cust")
	public String show(@RequestBody Customer cust){
		return cust.toString();
	}
}
