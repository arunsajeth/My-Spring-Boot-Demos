package edu.training.inventory.service;

import java.util.List;


import org.springframework.stereotype.Service;

import edu.training.inventory.dto.InventoryRequest;
import edu.training.inventory.dto.InventoryRequestOrginal;
import edu.training.inventory.model.Inventory;
import edu.training.inventory.repo.InventryRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class InventryService {
	
	private final InventryRepository inventryRepository;

	public List<InventoryRequest> isInStock(List<String> productName)
	{
		List<Inventory> ilist = inventryRepository.findByProductNameIn(productName);
		
		List<InventoryRequest> rlist = ilist.stream().map(product->mapToInventry(product)).toList();
		
		return rlist;
	}
	
	public InventoryRequest mapToInventry(Inventory inv)
	{
		return InventoryRequest.builder()
				.productName(inv.getProductName())
				.qunatity(inv.getQunatity()>0)
				.build();
	}
	
	public void create(InventoryRequestOrginal inventoryRequest)
	{
		Inventory inventory = Inventory.builder()
								.productName(inventoryRequest.getProductName())
								.qunatity(inventoryRequest.getQunatity())
								.build();
		inventryRepository.save(inventory);
	}

}
