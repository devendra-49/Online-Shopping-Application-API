package edu.onlineshoppingapplication.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.onlineshoppingapplication.entity.Order;

public interface OrderJPARepository extends JpaRepository<Order, Long> {
   public List<Order> findByUserId(Long userId);
}
