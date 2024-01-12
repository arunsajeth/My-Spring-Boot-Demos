package edu.training.product.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductRequest {
	
	
	private String productName;
	
	private Double productPrice;
	
	private Integer productQuantity;

}
