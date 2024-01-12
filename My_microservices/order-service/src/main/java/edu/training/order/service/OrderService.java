package edu.training.order.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import edu.training.order.dto.InventoryRequest;
import edu.training.order.dto.OrderLineItemsDto;
import edu.training.order.dto.OrderRequest;
import edu.training.order.dto.ProductResponse;
import edu.training.order.model.Order;
import edu.training.order.model.OrderLineItems;
import edu.training.order.repo.OrderReopository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrderService {
	
	private final OrderReopository orderReopository;
	
	private final WebClient.Builder webClientBuilder;
	
	public String placeOrder(OrderRequest orderRequest)
	{
		String msg = "";
		List<Order> or = new ArrayList<>();
		Order order = new Order();
		order.setOrderNo(UUID.randomUUID().toString());
		order.setOrderLineItem(orderRequest.getOrderLineItemsDtoList().stream().map(dto->mapTOOrderLineItomDto(dto)).toList());
		
		
		List<String> productName = order.getOrderLineItem().stream().map(orderItemList->orderItemList.getProductName()).toList();   // getting only productName from the list 
		InventoryRequest[] inventoryResponseArray = webClientBuilder.build().get()
													.uri("http://inventry-service/inventry",uriBuilder->uriBuilder.queryParam("productName", productName).build())
													.retrieve()
													.bodyToMono(InventoryRequest[].class)    // getting data as a list of inventory request
													.block();     // convert it as JSON object
		
		boolean stockCheckStatus =Arrays.stream(inventoryResponseArray).allMatch(inventory->inventory.isQunatity()) && inventoryResponseArray.length!=0;   // if all value in the list are true or above 0 then return true else return false
		
		System.out.println(stockCheckStatus);
		
		if(stockCheckStatus)
		{
			orderReopository.save(order);
			msg = "Order Placed Succesfully!!!";
			
		}
		else
		{
			msg = "Some of the Products are out of stock!!!";
			//throw new IllegalArgumentException("Some of the Products are out of stock!!!");
		}
		
		return msg;
		
	}
	
	public OrderLineItems mapTOOrderLineItomDto(OrderLineItemsDto dto)
	{
		return OrderLineItems.builder()
				.id(dto.getProductId())
				.productName(dto.getProductName())
				.price(dto.getProductPrice())
				.qunatity(dto.getProductQuantity())
				.build();
	}
	
	
	public ProductResponse[] getProducts()
	{
		ProductResponse[] productResponseArray = webClientBuilder.build().get()
													.uri("http://product-service/product")
													.retrieve()
													.bodyToMono(ProductResponse[].class)
													.block();
		return productResponseArray;
	}

}
