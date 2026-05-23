package com.sri.controller;


import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sri.model.Orders;
import com.sri.service.OrderService;

@Controller
public class MyController {

	@Autowired
	private OrderService service;
	
	@GetMapping("/")
	public String home() {
		return "home";
	}
	
	@GetMapping("/report")
	public String report(Map<String,Object>map,@PageableDefault(page=0,size=2,direction = Direction.ASC)Pageable page) {
		Page<Orders> list = service.getOrders(page);
		map.put("msg",list );
		return "report";
	}
	
	@GetMapping("/add")
	public String add(@ModelAttribute(name="order") Orders o) {	
		return "add";
	}
	
	@PostMapping("/added")
	public String added(@ModelAttribute(name="order") Orders o , RedirectAttributes attr) {	
		String order = service.addOrder(o);
		attr.addFlashAttribute("add",order);
		return "redirect:report";
	}
	
	@GetMapping("/edit")
	public String edit(@ModelAttribute(name="order") Orders o , @RequestParam(name="no",required=false)Integer id) {
		Orders editOrder = service.editOrder(id);
		BeanUtils.copyProperties( editOrder,o);
		return "edit";
	}
	
	@PostMapping("/update")
	public String update(@ModelAttribute(name="order") Orders o , RedirectAttributes attr) {	
		String update = service.update(o);
		attr.addFlashAttribute("update",update);
		return "redirect:report";
	}
	
	@GetMapping("/delete")
	public String edit(Map<String,Object>map,@RequestParam(name="no",required=false)Integer id) {
		String delete = service.delete(id);
		map.put("delete", delete);
		return "forward:report";
	}
	
	
}
