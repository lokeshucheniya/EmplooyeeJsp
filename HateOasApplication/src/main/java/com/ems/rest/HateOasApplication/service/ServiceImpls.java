package com.ems.rest.HateOasApplication.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ems.rest.HateOasApplication.pojo.Employee;
//import com.ems.rest.HateOasApplication.repo.EmployeeRepository;
import com.ems.rest.HateOasApplication.repo.EmployeeRepositoryMySql;

@Service
public class ServiceImpls implements ServiceInterface {

	@Autowired
	//EmployeeRepository dao;
	EmployeeRepositoryMySql dao;
	public ServiceImpls() {
	}

	@Override
	public void addNewEmployee(Employee emp) {

		dao.save(emp);
		System.out.println(searchEmployee(emp.getEmpId()));
	}

	@Override
	public List<Employee> viewAllEmployee() {
		System.out.println(dao);
		return dao.findAll();
	}

	@Override
	public void deleteEmployee(int empId) {

		dao.deleteById(empId);

	}

	public void updateEmployee(Employee emp) {
		dao.save(emp);
	}

	public Employee searchEmployee(int empId) {

		return dao.findByEmpId(empId).get();
	}

}
