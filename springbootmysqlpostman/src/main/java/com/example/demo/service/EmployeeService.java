package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Employee;
import com.example.demo.repo.EmployeeRepo;

@Service
public class EmployeeService {

	@Autowired
	EmployeeRepo repo;
	
	//Adding data into database
	public void createEmployee(Employee e)
	{
		repo.save(e);
	}
	
	//Getting all data from the database
	public List<Employee> viewAllEmployee()
	{
		return repo.findAll();
	}
	
	//Getting single data from the database
	public Employee viewEmployee(int id)
	{
		Optional<Employee> emp = repo.findById(id);
		if(emp.isPresent())
		{
			return emp.get();
		}
		else
		{
			return null;
		}
	}
	
	//Updating Data in the Database
	public void update(Employee emp)
	{
		repo.save(emp);
	}
	
	//Deleting data in the Database
	public void delete(int id)
	{
		repo.deleteById(id);
	}
	
}
