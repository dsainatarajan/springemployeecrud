package com.springtraining.springdatademo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepo extends 
	JpaRepository<Employee, Integer> {

	List<Employee> findByName(String ename);
	List<Employee> findByNameAndAddress(String ename, 
									String eaddress);
	
}
