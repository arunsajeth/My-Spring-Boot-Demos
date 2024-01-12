package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeService;

@Controller
public class HomeController {
	
	@Autowired
	Employee emp;
	
	@Autowired
	EmployeeService emps;
	
	@RequestMapping("/")
	//@ResponseBody
	public String Homepage()
	{
		return "Register.jsp";
	}
	
	@RequestMapping("display")
	public ModelAndView display(String uname)
	{
		ModelAndView mv = new ModelAndView("display.jsp");
		mv.addObject("uname", uname);
		return mv;
	}
	
	@RequestMapping("AddEmployee")
	@ResponseBody
	public String AddEmployee(Employee emp)
	{
		System.out.println(emp);
		emps.add(emp);
		return "SUCCESS";
	}
	
	@RequestMapping("view")
	public ModelAndView viewEmployee()
	{
		ModelAndView mv = new ModelAndView("viewdisplay.jsp");
		List<Employee> list = emps.view();
		mv.addObject("list",list);
		System.out.println(list);
		return mv;
	}

}
