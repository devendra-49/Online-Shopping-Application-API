package edu.onlineshoppingapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.onlineshoppingapplication.entity.CartItem;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {
}
