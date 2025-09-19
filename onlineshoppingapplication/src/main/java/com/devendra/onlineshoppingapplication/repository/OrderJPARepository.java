package com.devendra.onlineshoppingapplication.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devendra.onlineshoppingapplication.entity.Order;

public interface OrderJPARepository extends JpaRepository<Order, Long> {
   public List<Order> findByUserId(Long userId);
}
