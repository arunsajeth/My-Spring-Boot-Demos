package com.example.demo.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeControllers {
	
	@RequestMapping("/public")
	@ResponseBody
	public String publicuser()
	{
		return "Public Page";
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@RequestMapping("/admin")
	@ResponseBody
	public String adminuser()
	{
		return "Admin Page";
	}
	
	@PreAuthorize("hasRole('CUSTOMER')")
	@RequestMapping("/customer")
	@ResponseBody
	public String customeruser()
	{
		return "Customer Page";
	}

}
