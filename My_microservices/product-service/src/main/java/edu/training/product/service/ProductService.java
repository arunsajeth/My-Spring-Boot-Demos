package edu.training.product.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import edu.training.product.dto.InventoryRequestOrginal;
import edu.training.product.dto.ProductRequest;
import edu.training.product.dto.ProductResponse;
import edu.training.product.model.Product;
import edu.training.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class ProductService {
	
	// to declare interface as a reference use above annotation "RequiredArgsConstructor"
	private final ProductRepository productRepository;
	
	private final WebClient.Builder webClient;
	
	public void createNeweProduct(ProductRequest productrequest)
	{
		
		Product product = Product.builder()
				.productName(productrequest.getProductName())
				.productPrice(productrequest.getProductPrice())
				.productQuantity(productrequest.getProductQuantity())
				.build();
		
		productRepository.save(product);
		
		InventoryRequestOrginal inventoryRequestOrginal = InventoryRequestOrginal.builder()
														.productName(productrequest.getProductName())
														.qunatity(productrequest.getProductQuantity())
														.build();
		System.out.println(inventoryRequestOrginal);
		
		webClient.build().post()
		.uri("http://inventry-service/inventry").body(Mono.just(inventoryRequestOrginal),InventoryRequestOrginal.class)
		.retrieve()
		.bodyToMono(Void.class)
		.block();
		
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
