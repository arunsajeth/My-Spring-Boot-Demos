package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeService;

@RestController
public class EmployeeController {
	
	@Autowired
	EmployeeService service;
	
	@GetMapping("/employee")
	public List<Employee> getEmployees()
	{
		return service.viewAllEmployee();
	}
	
	@GetMapping("/employee/{eid}")
	public Employee getEmployee(@PathVariable("eid") int id)
	{
		return service.viewEmployee(id);
	}
	
	@PostMapping("/employee")
	public String addEmployee(@RequestBody Employee emp)
	{
		service.createEmployee(emp);
		return "Created";
	}
	
	@PutMapping("/employee")
	public String updateEmployee(@RequestBody Employee emp)
	{
		service.update(emp);
		return "Updated";
	}
	
	@DeleteMapping("/employee/{eid}")
	public String deleteEmployee(@PathVariable("eid") int id)
	{
		service.delete(id);
		return "Deleted";
	}
	
}
