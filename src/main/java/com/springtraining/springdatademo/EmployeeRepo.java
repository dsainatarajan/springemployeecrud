package com.springtraining.springdatademo;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepo extends 
PagingAndSortingRepository<Employee, Integer> {

	List<Employee> findByName(String ename);
	List<Employee> findByNameAndAddress(String ename, 
									String eaddress);
	
}
