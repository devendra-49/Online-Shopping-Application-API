package com.devendra.onlineshoppingapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devendra.onlineshoppingapplication.entity.CartItem;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {
}
