package com.devendra.onlineshoppingapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devendra.onlineshoppingapplication.entity.OrderItem;

public interface OrderItemJPARepository extends JpaRepository<OrderItem, Long>{

}
