package com.ems.rest.HateOasApplication.repo;


import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.ems.rest.HateOasApplication.pojo.Employee;

@Repository
public interface EmployeeRepositoryMySql extends MongoRepository<Employee, Integer>  {
	
	Optional<Employee> findByEmpId(int empId);
	void deleteByEmpId(int empId);
}
