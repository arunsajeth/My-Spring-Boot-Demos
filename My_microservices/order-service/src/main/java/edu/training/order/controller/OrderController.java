package edu.training.order.controller;


import java.util.concurrent.CompletableFuture;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.training.order.dto.OrderRequest;
import edu.training.order.dto.ProductResponse;
import edu.training.order.service.OrderService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import io.github.resilience4j.timelimiter.annotation.TimeLimiter;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
public class OrderController {
	
	private final OrderService orderService;
	
	@PostMapping("/add")
	@CircuitBreaker(name="inventry",fallbackMethod = "fallBackMethod")
	@TimeLimiter(name="inventry")
	@Retry(name="inventry")
	public CompletableFuture<String> placeorder(@RequestBody OrderRequest orderRequest)
	{
		 String msg =orderService.placeOrder(orderRequest);
		return CompletableFuture.supplyAsync(()->msg);
	}
	
	@GetMapping("/products")
	public ProductResponse[] getAllProducts()
	{
		return orderService.getProducts();
	}
	
	public CompletableFuture<String> fallBackMethod(OrderRequest orderRequest, RuntimeException exception)
	{
		System.out.println("FallBack Mechanism");
		return CompletableFuture.supplyAsync(()->"Call back method error in placing order");
	}
}
