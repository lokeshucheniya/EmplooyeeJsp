package com.ems.webproject.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import com.ems.webproject.pojo.Employee;
//import com.google.gson.Gson;


@Controller
public class EmpController {
	
	@RequestMapping("/home")
	public String home(Model model) {
		
		return "home";
	}
	
	
	@RequestMapping("/view/{id}")
	public String viewEmployee(Model model, @PathVariable int id){
		//Gson gson = new Gson();
		RestTemplate resttemplate = new RestTemplate();
		Employee response = resttemplate.getForObject("http://localhost:8081/employee/view/"+id, Employee.class); 
		model.addAttribute("emp", response);
		/*Employee[] viewAllEmp = resttemplate.getForObject("http://localhost:8080/employee/view", Employee[].class);*/
		/*model.addAttribute("emp", viewAllEmp);*/
		System.out.println(response);
		return "view";
	}
	
	/*@RequestMapping("/view")
	public String viewAllEmployee(Model model,@PathVariable int id){
		//Gson gson = new Gson();
		RestTemplate resttemplate = new RestTemplate();
		ResponseEntity<?> response = resttemplate.getForEntity("http://localhost:8080/employee"+id, Employee.class); 
		model.addAttribute("emp", response.getBody());
		Employee[] viewAllEmp = resttemplate.getForObject("http://localhost:8080/employee/view", Employee[].class);
		model.addAttribute("emp", viewAllEmp);
		System.out.println(response.getBody());
		return "view";
	}*/
	
}