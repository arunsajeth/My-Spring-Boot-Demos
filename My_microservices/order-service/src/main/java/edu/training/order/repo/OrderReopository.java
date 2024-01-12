package edu.training.order.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.training.order.model.Order;

public interface OrderReopository extends JpaRepository<Order, Integer> {

}
