package com.sri.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.sri.model.Product;


@Controller
public class MyController {

	Product p1 = new Product(1,"Laptop",50000.0);
	Product p2 = new Product(2,"Mobile",20000.0);
	Product p3 = new Product(3,"Tablet",15000.0);
	List<Product> list = List.of(p1,p2,p3);
	
	@GetMapping("/")
	public String show(Model model) {
		
		model.addAttribute("product",list);
		return "show";
	}
}
