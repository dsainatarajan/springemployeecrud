package com.springtraining.springdatademo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

	@Autowired
	EmployeeRepo empRepo;
	
	@GetMapping("/employees")
	List<Employee> getAllEmployees(){
		return empRepo.findAll();
	}
	
	@PostMapping("/create_employee")
	Employee createEmployee(@RequestBody Employee e) {
		return empRepo.save(e);
	}
	
	@PutMapping("/update_employee/{id}")
	Employee updateEmployee(@PathVariable int id, 
					@RequestBody Employee e) {
		Employee e1 = empRepo.findById(id).get();
		if(e1!= null) {
			if(e.getName()!= null && e.getName() != "")
				e1.setName(e.getName());
			if(e.getAddress()!= null && e.getAddress() != "")
				e1.setAddress(e.getAddress());
			if(e.getSal() != 0.0)
				e1.setSal(e.getSal());
			return empRepo.save(e1);
		}		
		return null;
	}

	@GetMapping("/get_employee_by_id/{id}")
	Optional<Employee> getEmployeeByID(@PathVariable int id) {
		return empRepo.findById(id);
		
	}
	
	@GetMapping("/get_employee_by_name/{name}")
	List<Employee> getEmployeeByName(@PathVariable String name) {
		return empRepo.findByName(name);		
	}
	
	@DeleteMapping("/delete_employee_by_id/{id}")
	String deleteEmployeeByID(@PathVariable int id) {
		empRepo.deleteById(id);
		return "Employee with ID: " +id + "Deleted!";
		
	}
	
}
