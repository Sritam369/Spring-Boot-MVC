package com.sri.controller;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sri.model.Company;
import com.sri.model.Customer;

@RestController
public class MyController {

	@GetMapping("/cust")
	public ResponseEntity<Customer> show(){
		Customer cust = new Customer(1001,"sritam",5600.0f,new String[] {"blue","red"},List.of("subrat","jeevan","konda"),Set.of("99999","88888"),Map.of("aadhar","64464","pan","65421d54"),new Company("samsung","hyd","electronics",4000));
		return new ResponseEntity<Customer>(cust,HttpStatus.OK);
	}
}
