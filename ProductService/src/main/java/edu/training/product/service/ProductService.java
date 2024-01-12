package edu.training.product.service;

import java.util.List;

import org.springframework.stereotype.Service;

import edu.training.product.dto.ProductRequest;
import edu.training.product.dto.ProductResponse;
import edu.training.product.model.Product;
import edu.training.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductService {
	
	// to declare interface as a reference use above annotation "RequiredArgsConstructor"
	private final ProductRepository productRepository;
	
	public void createNeweProduct(ProductRequest productrequest)
	{
		
		Product product = Product.builder()
				.productName(productrequest.getProductName())
				.productPrice(productrequest.getProductPrice())
				.productQuantity(productrequest.getProductQuantity())
				.build();
		
		productRepository.save(product);
	}
	
	public List<ProductResponse> getProducts()
	{
		List<Product> products =  productRepository.findAll();
		
		// we also use for each loop within the add function call the map to product response method
		List<ProductResponse> responseProduct = products.stream().map(pro->mapToProductResponse(pro)).toList();
		
		return responseProduct;
	}
	
	// for converting product object into product response object
	private ProductResponse mapToProductResponse(Product pro)
	{
		ProductResponse ps = new ProductResponse();
		
		ps.setProductId(pro.getProductId());
		ps.setProductName(pro.getProductName());
		ps.setProductPrice(pro.getProductPrice());
		ps.setProductQuantity(pro.getProductQuantity());
		
		// **or use below step to avoid "new" keyword**
		
//		Product ps = Product.builder()
//				.productId(pro.getProductId())
//				.productName(pro.getProductName())
//				.productPrice(pro.getProductPrice())
//				.productQuantity(pro.getProductQuantity())
//				.build();
		
		return ps;
	}

}
