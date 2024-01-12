package com.example.demo.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.EmployeeRepo;
import com.example.demo.entity.Employee;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Controller
public class homecontroller {
	
	@Autowired
	private Employee emp;
	
	@Autowired
	private EmployeeRepo repo;
	
	@RequestMapping("/")
	public String Home()
	{
		return "menu.jsp";
	}
	
	@RequestMapping("create")
	public String add()
	{
		return "register.jsp";
	}
	
	@RequestMapping("view")
	@ResponseBody
	public ModelAndView view()
	{
		List<Employee> list = new ArrayList<>();
		ModelAndView mv = new ModelAndView("display.jsp");
		list = (List<Employee>) repo.findAll();
		mv.addObject("list",list);
		
		return mv;
	}
	
	@RequestMapping("search")
	public String search()
	{
		return "search.jsp";
	}
	
	@RequestMapping("add")
	public void employeecreated(Employee e, HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
	{
		repo.save(e);
		
		RequestDispatcher rd = req.getRequestDispatcher("register.jsp");
		rd.include(req, res);
		res.getWriter().println("Employee Created");
	}
	
	@RequestMapping("empsearch")
	@ResponseBody
	public ModelAndView searchbydept(String oper,String data)
	{
		ModelAndView mv = new ModelAndView("searchdisplay.jsp");
		List<Employee> list = new ArrayList<>();
		switch(oper)
		{
		case "Search By Name": 
			list = repo.findByEname(data);
			mv.addObject("list",list);
			return mv;
		case "Search By Salary":
			list = repo.findBySalary(Integer.parseInt(data));
			mv.addObject("list",list);
			return mv;
		case "Search By Departments":
			list = repo.findByDept(data);
			mv.addObject("list",list);
			return mv;
		
		}
		return mv;
	}
}
