package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.Employee;


@Service
public class EmployeeService {
	
	public static List<Employee> list = new ArrayList<>();
	
	public void add(Employee emp)
	{
		list.add(emp);
		System.out.println(list);
	}
	
	public List<Employee> view()
	{
		return list;
	}

}
