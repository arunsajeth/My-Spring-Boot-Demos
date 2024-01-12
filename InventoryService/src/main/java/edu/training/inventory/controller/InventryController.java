package edu.training.inventory.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.training.inventory.dto.InventoryRequest;
import edu.training.inventory.service.InventryService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/inventry")
@RequiredArgsConstructor
public class InventryController {
	
	private final InventryService inventryService;
	
	@GetMapping
	public List<InventoryRequest> isInStock(@RequestBody List<String> productName)
	{
		return inventryService.isInStock(productName);
	}

}
