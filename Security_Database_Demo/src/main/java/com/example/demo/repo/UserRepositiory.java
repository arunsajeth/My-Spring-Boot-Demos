package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.User;

public interface UserRepositiory extends JpaRepository<User, Integer> {
	
	User findByUname(String uname);

}
