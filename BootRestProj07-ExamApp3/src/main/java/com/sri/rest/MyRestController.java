package com.sri.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sri.model.Product;

@RestController
public class MyRestController {

	@GetMapping("/product")
	public ResponseEntity<Product> show(){
		Product p = new Product(101,"mobile","electronics",25000.0);
		return new ResponseEntity<Product>(p,HttpStatus.OK);
	}
	
	@PutMapping("/update")
	public ResponseEntity<Product> update(@RequestBody Product p){	
		return new ResponseEntity<Product>(p,HttpStatus.OK);
	}
}
