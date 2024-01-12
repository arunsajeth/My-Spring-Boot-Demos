package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.entity.Employee;
import com.example.demo.repo.EmployeeRepo;

@Controller
public class EmployeeController {

	@Autowired
	private Employee emp;
	
	@Autowired
	private EmployeeRepo repo;
	
	@RequestMapping("/")
	public String home()
	{
		return "index.jsp";
	}
	
	@RequestMapping("/create")
	@ResponseBody
	public String add(Employee e)
	{
		repo.save(e);
		return "Employee Created";
	}
	
	@RequestMapping("/view")
	@ResponseBody
	public String display()
	{
		return repo.findAll().toString();
	}
	
	
}
