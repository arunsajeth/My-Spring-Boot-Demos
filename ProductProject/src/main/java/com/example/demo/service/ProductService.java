package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Product;
import com.example.demo.repo.ProductRepo;

@Service
public class ProductService {
	
	
	@Autowired
	ProductRepo repo;
	
	public List<Product> getProducts()
	{
		return repo.findAll();
	}
	
	public Product getProduct(String pid)
	{
		Optional<Product> pro = repo.findById(pid);
		if(pro.isPresent())
		{
			return pro.get();
		}
		else
		{
			return null;
		}
	}
	
	public void createProduct(Product pro)
	{
		repo.save(pro);
	}
	
	public void delete(String pid)
	{
		repo.deleteById(pid);
	}
	
	public void edit(Product pro)
	{
		repo.save(pro);
	}
	
	public List<Product> searchname(String name)
	{
		return repo.findByPname(name);
	}

}
