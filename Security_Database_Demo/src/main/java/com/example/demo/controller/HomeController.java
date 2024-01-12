package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.User;
import com.example.demo.repo.UserRepositiory;

@RestController
@RequestMapping("/app")
public class HomeController {
	
	@Autowired
	UserRepositiory repo;
	
	@GetMapping("/public")
	public ResponseEntity<String> publicuser()
	{
		User user = new User();
		user.setUid(18);
		user.setUname("admin");
		user.setRole("ROLE_ADMIN");
		user.setPassword(new BCryptPasswordEncoder().encode("123"));
		repo.save(user);
		user.setUid(19);
		user.setUname("cust");
		user.setRole("ROLE_CUSTOMER");
		user.setPassword(new BCryptPasswordEncoder().encode("1234"));
		repo.save(user);
		return ResponseEntity.ok("I am a user!!!!");
	}
	
	@GetMapping("/admin")
	public ResponseEntity<String> adminuser()
	{
		return ResponseEntity.ok("I am a admin");
	}
	
	@GetMapping("/cust")
	public ResponseEntity<String> cUser()
	{
		
		return ResponseEntity.ok("I am a Administrator User");
	}
}
