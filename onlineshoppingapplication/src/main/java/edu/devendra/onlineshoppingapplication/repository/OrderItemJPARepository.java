package edu.devendra.onlineshoppingapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.devendra.onlineshoppingapplication.entity.OrderItem;

public interface OrderItemJPARepository extends JpaRepository<OrderItem, Long>{

}
