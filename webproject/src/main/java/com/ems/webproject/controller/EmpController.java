package com.ems.webproject.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import com.ems.webproject.pojo.Employee;
import com.google.gson.Gson;


@Controller
public class EmpController {
	
	@RequestMapping("/home")
	public String home(Model model) {
		
		return "home";
	}
	
	
	@RequestMapping("/view")
	public String viewAllEmployee(Model model){
		Gson gson = new Gson();
		RestTemplate resttemplate = new RestTemplate();
		Employee[] viewAllEmp = resttemplate.getForObject("http://localhost:8080/employee/view", Employee[].class);
		model.addAttribute("emp", viewAllEmp);
		return "view";
	}
	
}