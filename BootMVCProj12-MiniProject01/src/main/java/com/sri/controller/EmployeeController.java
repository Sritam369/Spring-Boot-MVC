package com.sri.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sri.entity.Employee;
import com.sri.service.EmployeeService;

@Controller
public class EmployeeController {
	
	@Autowired
	private EmployeeService service;

	@GetMapping("/")
	public String home() {
		return "home";
	}
	
	@GetMapping("/report")
	public String reportPage(Map<String,Object>map) {
		List<Employee> selectEmp = service.selectEmp();
		map.put("result", selectEmp);	
		return "report";
	}
	
	@GetMapping("/add")
	public String addEmp(@ModelAttribute("emp") Employee e) {
		return "add_emp";
	}
	
	@PostMapping("/submit")
	public String empSubmit(@ModelAttribute("emp") Employee e , RedirectAttributes attr) {
		String msg = service.addEmp(e);
		attr.addFlashAttribute("resultMsg",msg);
		return "redirect:report";
	}
	
	@GetMapping("/emp_edit")
	public String editEmp(@RequestParam(name="empNo",required=false)Integer no) {
		return "edit_emp";
	}
}
