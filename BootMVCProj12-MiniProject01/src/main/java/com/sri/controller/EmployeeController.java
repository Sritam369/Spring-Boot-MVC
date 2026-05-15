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
	public String editEmp(@RequestParam(name="no",required=false)Integer no,@ModelAttribute("emp")Employee e1) {
		Employee e = service.findId(no);
		BeanUtils.copyProperties(e, e1);
		return "edit_emp";
	}
	
	@PostMapping("/edit")
	public String editEmpData(@ModelAttribute("emp")Employee e,RedirectAttributes attr) {
		String update = service.update(e);
		attr.addFlashAttribute("updateMsg",update);
		return "redirect:report";
	}
	
	@GetMapping("/emp_delete")
	public String deleteEmp(@RequestParam(name="no",required=false)Integer no,Map<String,Object>map) {
		String msg = service.delete(no);
		map.put("deleteMsg",msg);
		return "forward:report";
	}
}
