package com.example.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entity.Product;

public interface ProductRepo extends JpaRepository<Product, String> {
	
	@Query("from Product where pname like ?1%")
	List<Product> findByPname(String pname);

}
