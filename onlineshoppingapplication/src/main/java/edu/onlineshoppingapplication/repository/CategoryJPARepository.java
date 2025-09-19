package edu.onlineshoppingapplication.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.onlineshoppingapplication.entity.Category;
import edu.onlineshoppingapplication.entity.Product;

public interface CategoryJPARepository extends JpaRepository<Category, Long> {
	
	public Optional<Category> findByName(String Name);


}
