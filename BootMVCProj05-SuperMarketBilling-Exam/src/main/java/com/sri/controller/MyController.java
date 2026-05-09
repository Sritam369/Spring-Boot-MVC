package com.sri.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sri.entity.Customer;

@Controller
public class MyController {

	Customer c = new Customer();
	
	@RequestMapping("/")
	public String show(Map<String,Object> map) {
		c.setId(101);
		c.setsName("sritam");
		c.setpName("remote");
		c.setQty(5);
		c.setPrice(2000.0);
		Double total = c.getQty()*c.getPrice();
		Double gst = total*18/100;
		c.setGst(gst);
		Double discount = 0.0;
		if(total>5000) {
			 discount = total*10/100;
		}
		c.setDiscount(discount);
		Double bill = total+gst-discount;
		c.setBill(bill);
		map.put("Customer", c);
		return "show";
	}
}
