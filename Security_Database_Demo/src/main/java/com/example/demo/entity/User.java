package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class User {
	
	@Id
	private int uid;
	private String uname;
	private String password;
	private String role;
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public String getRole() {
		return role;
	}


	public void setRole(String role) {
		this.role = role;
	}



	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	@Override
	public String toString() {
		return "User [uid=" + uid + ", uname=" + uname + ", password=" + password + ", role=" + role + "]";
	}

		

}
