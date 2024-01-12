package edu.training.inventory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

import edu.training.inventory.model.Inventory;
import edu.training.inventory.repo.InventryRepository;

@SpringBootApplication
@EnableDiscoveryClient
public class InventoryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryServiceApplication.class, args);
	}
	
//	@Bean
//	public CommandLineRunner loadData(InventryRepository inventryRepository)
//	{
//		return args->{
//			Inventory phone = Inventory.builder().build();
//			
//			phone.setProductName("iphone");
//			phone.setQunatity(10);
//			inventryRepository.save(phone);
//			
//			Inventory laptop = Inventory.builder().build();
//			
//			laptop.setProductName("laptop");
//			laptop.setQunatity(10);
//			inventryRepository.save(laptop);
//			
//		};
//	}

}
