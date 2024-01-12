package com.example.demo.security;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.example.demo.entity.User;
import com.example.demo.repo.UserRepositiory;

@Component
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	UserRepositiory userrepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		User user = userrepo.findByUname(username);
		
		if(user == null)
			throw new UsernameNotFoundException("User 404");
		
		
		return new MyUserDetilas(user); 
	}

}
