package com.example.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Emoloyee {
	
	@Id
	private int eid;
	private String eName;
	public int getEid() {
		return eid;
	}
	public void setEid(int eid) {
		this.eid = eid;
	}
	public String geteName() {
		return eName;
	}
	public void seteName(String eName) {
		this.eName = eName;
	}
	@Override
	public String toString() {
		return "Emoloyee [eid=" + eid + ", eName=" + eName + "]";
	}
	
	

}
