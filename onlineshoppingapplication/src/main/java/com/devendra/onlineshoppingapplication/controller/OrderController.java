package com.devendra.onlineshoppingapplication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.devendra.onlineshoppingapplication.entity.Order;
import com.devendra.onlineshoppingapplication.entity.OrderStatus;
import com.devendra.onlineshoppingapplication.service.OrderService;

@RestController
@RequestMapping("/api")
public class OrderController {
	
	@Autowired
	private OrderService orderservice;
	
	  @GetMapping("/order/{userId}")
	    public ResponseEntity<List<Order>> getOrdersByUser(@PathVariable Long userId) {
	        return ResponseEntity.ok(orderservice.getOrdersByUser(userId));
	  }
	  
	  @GetMapping("/order") // Admin only
	    public ResponseEntity<List<Order>> getAllOrders() {
	        return ResponseEntity.ok(orderservice.getAllOrders());
	  }
	  
	    @PutMapping("/order/{orderId}/status")
	    public ResponseEntity<Order> updateStatus(@PathVariable Long orderId,
	                                              @RequestParam OrderStatus status) {
	        return ResponseEntity.ok(orderservice.updateOrderStatus(orderId, status));
	    }

	    @PutMapping("/order/{orderId}/cancel")
	    public ResponseEntity<Order> cancelOrder(@PathVariable Long orderId) {
	        return ResponseEntity.ok(orderservice.cancelOrder(orderId));
	    }
	  
}
