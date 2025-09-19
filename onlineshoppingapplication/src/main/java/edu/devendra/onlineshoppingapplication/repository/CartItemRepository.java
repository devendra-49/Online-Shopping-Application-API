package edu.devendra.onlineshoppingapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.devendra.onlineshoppingapplication.entity.CartItem;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {
}
