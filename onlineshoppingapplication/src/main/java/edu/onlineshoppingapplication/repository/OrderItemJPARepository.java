package edu.onlineshoppingapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.onlineshoppingapplication.entity.OrderItem;

public interface OrderItemJPARepository extends JpaRepository<OrderItem, Long>{

}
