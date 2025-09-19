package edu.devendra.onlineshoppingapplication.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.devendra.onlineshoppingapplication.entity.Category;
import edu.devendra.onlineshoppingapplication.entity.Product;

public interface CategoryJPARepository extends JpaRepository<Category, Long> {
	
	public Optional<Category> findByName(String Name);


}
