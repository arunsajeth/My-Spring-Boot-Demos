package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Product;
import com.example.demo.service.ProductService;

@RestController
public class ProductController {

	@Autowired
	Product pro;
	
	@Autowired
	ProductService service;
	
	@CrossOrigin(origins = "http://localhost:4200/")
	@PostMapping("/product")
	public String addProduct(@RequestBody Product pro)
	{
		service.createProduct(pro);
		return "Created";
	}
	
	@CrossOrigin(origins = "http://localhost:4200/")
	@GetMapping("/product")
	public List<Product> getallProduct()
	{
		return service.getProducts();
	}
	
	@CrossOrigin(origins = "http://localhost:4200/")
	@GetMapping("/product/{pid}")
	public Product getproduct(@PathVariable ("pid") String id)
	{
		System.out.println(service.getProduct(id));
		return service.getProduct(id);
	}
	
	@CrossOrigin(origins = "http://localhost:4200/")
	@DeleteMapping("/product/{pid}")
	public String deleteProduct(@PathVariable ("pid") String id)
	{
		System.out.println("Deleting!!!!!");
		service.delete(id);
		return "Deleted";
	}
	
	@CrossOrigin(origins = "http://localhost:4200/")
	@PutMapping("/product")
	public String updateProduct(@RequestBody Product pro)
	{
		 service.edit(pro);
		 return "Updated";
	}
	
	@CrossOrigin(origins = "http://localhost:4200/")
	@GetMapping("/searchproduct/{pname}")
	public List<Product> getByName(@PathVariable ("pname") String pname)
	{
		return service.searchname(pname);
	}
}
