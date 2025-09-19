package com.devendra.onlineshoppingapplication.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devendra.onlineshoppingapplication.entity.Category;
import com.devendra.onlineshoppingapplication.entity.Product;

public interface CategoryJPARepository extends JpaRepository<Category, Long> {
	
	public Optional<Category> findByName(String Name);


}
