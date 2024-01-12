package edu.training.inventory.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.training.inventory.dto.InventoryRequest;
import edu.training.inventory.dto.InventoryRequestOrginal;
import edu.training.inventory.service.InventryService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/inventry")
@RequiredArgsConstructor
public class InventryController {
	
	private final InventryService inventryService;
	
	@GetMapping
	public List<InventoryRequest> isInStock(@RequestParam List<String> productName) throws InterruptedException
	{
		System.out.println("Thread Started Sleeping");
		Thread.sleep(10000);
		System.out.println("Thread Awaken");
		return inventryService.isInStock(productName);
	}
	
	@PostMapping
	public String createInventory(@RequestBody InventoryRequestOrginal inventoryRequest)
	{
		System.out.println("heeeee");
		System.out.println(inventoryRequest);
		inventryService.create(inventoryRequest);
		return "Created";
	}

}
