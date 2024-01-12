package edu.training.product.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.training.product.dto.ProductRequest;
import edu.training.product.dto.ProductResponse;
import edu.training.product.service.ProductService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {
	
	private final ProductService productService;
	
	@PostMapping
	public String createProduct(@RequestBody ProductRequest productRequest)
	{
		productService.createNeweProduct(productRequest);
		return "Created";
		
	}
	
	@GetMapping
	public List<ProductResponse> displayProduct()
	{
		return productService.getProducts();
	}

}
