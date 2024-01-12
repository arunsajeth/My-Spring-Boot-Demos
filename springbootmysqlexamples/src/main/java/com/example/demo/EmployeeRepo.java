package com.example.demo;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import com.example.demo.entity.Employee;

public interface EmployeeRepo extends CrudRepository<Employee, Integer> {
	
	List<Employee> findByDept(String dept);
	
	List<Employee> findBySalary(int salary);
	
	
	List<Employee> findByEname(String ename);
	
	List<Employee> findBySalaryGreaterThan(int salary);
	
	List<Employee> findBySalaryLessThan(int salary);
	

}
