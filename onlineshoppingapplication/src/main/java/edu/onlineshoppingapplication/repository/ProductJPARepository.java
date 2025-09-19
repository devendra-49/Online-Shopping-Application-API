package edu.onlineshoppingapplication.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.onlineshoppingapplication.entity.Product;
import edu.onlineshoppingapplication.entity.User;

public interface ProductJPARepository extends JpaRepository<Product, Long> {
	
	public Optional<Product> findByName(String Name);

}
