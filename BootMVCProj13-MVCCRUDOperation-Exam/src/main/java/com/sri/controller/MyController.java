package com.sri.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sri.entity.FoodOrder;
import com.sri.service.MyService;

@Controller
public class MyController {

	@Autowired
	private MyService service;
	
	@GetMapping("/")
	public String home() {
		return "home";
	}
	
	@GetMapping("/report")
	public String report(Map<String,Object>map) {
		List<FoodOrder> show = service.show();
		map.put("result", show);
		return "report";
	}
	
	@GetMapping("/add")
	public String addOrder(@ModelAttribute("food")FoodOrder order) {
		return "add_order";
	}
	
	@PostMapping("/insert")
	public String insertOrder(@ModelAttribute("food")FoodOrder order,RedirectAttributes attr) {
		order.setTotalAmt();
		String insert = service.insert(order);
		attr.addFlashAttribute("insert",insert);
		return "redirect:report";
	}
	
	@GetMapping("/edit_order")
	public String editOrder(@ModelAttribute("food")FoodOrder order , @RequestParam(name="no", required=false)Integer no) {
		FoodOrder orderById = service.findOrderById(no);
		BeanUtils.copyProperties(orderById,order);
		return "edit_order";
	}
	
	@PostMapping("/update")
	public String updateOrder(@ModelAttribute("food")FoodOrder order,RedirectAttributes attr) {
		order.setTotalAmt();
		String update = service.update(order);
		attr.addFlashAttribute("update",update);
		return"redirect:report";
	}
	
	@GetMapping("/delete_order")
	public String deleteOrder(@RequestParam(name="no" , required=false)Integer id , Map<String,Object>map) {
		String delete = service.delete(id);
		map.put("delete", delete);
		return "forward:report";
	}
}
