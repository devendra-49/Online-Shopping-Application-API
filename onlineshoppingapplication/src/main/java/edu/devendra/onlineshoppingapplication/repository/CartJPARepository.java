package edu.devendra.onlineshoppingapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.devendra.onlineshoppingapplication.entity.Cart;

public interface CartJPARepository extends JpaRepository<Cart, Long> {

	public Cart findByUserId(long userId); // direct return instead of Optional
	
}
