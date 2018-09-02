package com.ems.webproject.controller;


import java.util.ArrayList;
import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
//import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import com.ems.webproject.pojo.Employee;
//import com.google.gson.Gson;


@Controller
public class EmpController {
	
	
	RestTemplate resttemplate = new RestTemplate();
	@RequestMapping("/home")
	public String home(Model model) {
		
		return "home";
	}
	
	
	@RequestMapping("/view/{id}")
	public String viewEmployee(Model model, @PathVariable int id){
		//Gson gson = new Gson();
		//RestTemplate resttemplate = new RestTemplate();
		/*ResponseEntity<?> response = resttemplate.getForEntity("http://localhost:8081/employee/view/"+id, Employee.class); */
		ResponseEntity<?> response = resttemplate.exchange("http://localhost:8081/employee/view/"+id, HttpMethod.GET, null, new ParameterizedTypeReference<Employee>(){});
		model.addAttribute("emp", response.getBody());
		/*Employee[] viewAllEmp = resttemplate.getForObject("http://localhost:8080/employee/view", Employee[].class);*/
		/*model.addAttribute("emp", viewAllEmp);*/
		System.out.println(response.getBody());
		return "view";
	}
	
	@RequestMapping("/viewAllEmployee")
	public String viewAllEmployee(Model model){
		//Gson gson = new Gson();
		ResponseEntity<?> response = resttemplate.exchange("http://localhost:8081/employee/view", HttpMethod.GET, null, new ParameterizedTypeReference<List<Employee>>(){});
		model.addAttribute("employee", response.getBody());
		System.out.println(response.getBody());
		return "viewAllEmployee";
	}
	
	@SuppressWarnings("rawtypes")
	@RequestMapping(value="/add")
	public String addNewEmplopee(Model model) { 
		ResponseEntity<ArrayList> response = resttemplate.getForEntity("http://localhost:8081/employee/view", ArrayList.class);
		System.out.println(response);
		return "home";
	}
	
	/*@RequestMapping("/search")
	public String searchEmployee() {
		return "search";
	}*/
	
	@RequestMapping("/search")
	public String searchEmployee(@RequestParam("employeeId") int empId, Model model) {
		ResponseEntity<?> response = resttemplate.exchange("http://localhost:8081/employee/view/"+empId, HttpMethod.GET, null, new ParameterizedTypeReference<Employee>(){});
		model.addAttribute("employeeId",response.getBody());
		System.out.println(response.getBody());
		return "view";

	}
}