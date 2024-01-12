package edu.training.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.training.product.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
