package edu.training.inventory.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.training.inventory.model.Inventory;

public interface InventryRepository extends JpaRepository<Inventory, Integer> {
	
	List<Inventory> findByProductNameIn(List<String> productName);

}
