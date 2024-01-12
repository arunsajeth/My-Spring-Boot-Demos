package edu.training.jio.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.training.jio.model.MyJio;

public interface JioRepository extends JpaRepository<MyJio, Integer> {

}
