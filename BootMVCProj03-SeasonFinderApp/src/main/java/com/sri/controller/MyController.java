package com.sri.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sri.service.ISeasonFinder;

@Controller
public class MyController {

	@Autowired
	private ISeasonFinder find;
	
	@RequestMapping("/")
	public String showHome() {
		return "welcome";
	}
	
	@RequestMapping("/season")
	public String showSeason(Map<String,Object>map) {
		String displaySeason = find.displaySeason();
		map.put("season", displaySeason);
		return "display";
	}
}
