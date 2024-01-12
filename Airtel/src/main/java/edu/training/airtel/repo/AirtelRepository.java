package edu.training.airtel.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.training.airtel.model.MyAirtel;

public interface AirtelRepository extends JpaRepository<MyAirtel, Integer> {

}
