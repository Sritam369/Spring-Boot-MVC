package com.sri.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sri.entity.Airplane;

@Controller
public class MyController {

	Airplane a = new Airplane();
	
	@RequestMapping("/")
	public String show(Map<String,Object> map) {
		a.setId(101);
		a.setPName("sritam");
		a.setFName("air india");
		a.setTicket(5);
		a.setTicketPrice(5000.0);
		Double fare = a.getTicket()*a.getTicketPrice();
		a.setAirFare(fare);
		a.setTax(1800.0);
		Double finalAmt = fare+a.getTax();
		a.setFinalAmount(finalAmt);
		map.put("Airplane", a);
		return "show";
	}
}
