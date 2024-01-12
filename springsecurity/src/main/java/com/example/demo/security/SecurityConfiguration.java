package com.example.demo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableMethodSecurity
public class SecurityConfiguration {
	
	@Bean
	public PasswordEncoder passwordEncoder()
	{
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public SecurityFilterChain mySecurityConfig(HttpSecurity http) throws Exception
	{
		http.csrf().disable()    
		.authorizeHttpRequests()
//		.requestMatchers("/admin")
//		.hasRole("ADMIN")
//		.requestMatchers("/customer")
//		.hasRole("CUSTOMER")
//		.requestMatchers("/public")
//		.permitAll()    
		.anyRequest()  
		.authenticated()
		.and()
		.formLogin();
		
		return http.build();
	}
	
	@Bean
	public UserDetailsService userCredentialsService()
	{
		
		// Always roles should be uppercase as it is Constant
		UserDetails adminCredentials = User.withUsername("Admin").password(passwordEncoder().encode("Reset@123")).roles("ADMIN").build();  
		UserDetails customerCredentials = User.withUsername("Customer").password(passwordEncoder().encode("Reset@123")).roles("CUSTOMER").build();
		
		// beacuse userDetailsService is interface so we can't return it so we used class which implement the interface
		InMemoryUserDetailsManager myuserdetails = new InMemoryUserDetailsManager(adminCredentials,customerCredentials);
		
		return myuserdetails;
	}
}
