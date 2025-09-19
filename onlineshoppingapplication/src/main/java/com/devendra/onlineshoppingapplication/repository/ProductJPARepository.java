package com.devendra.onlineshoppingapplication.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devendra.onlineshoppingapplication.entity.Product;
import com.devendra.onlineshoppingapplication.entity.User;

public interface ProductJPARepository extends JpaRepository<Product, Long> {
	
	public Optional<Product> findByName(String Name);

}
