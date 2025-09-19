package edu.onlineshoppingapplication.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.onlineshoppingapplication.entity.Order;
import edu.onlineshoppingapplication.entity.OrderStatus;
import edu.onlineshoppingapplication.repository.OrderJPARepository;

@Repository
public class OrderDAO {
	
	@Autowired
	private OrderJPARepository orderjpa;
	
//	public  String AddOrder(Order orders) {
//		ojpa.save(orders);
//		return "Order Added...";
//	}
	
//	public Optional<Order> findOderUsingId(long id) {
//		return ojpa.findById(id);
//	}
	
	public List<Order> getOrdersByUser(Long userId) {
	    return orderjpa.findByUserId(userId);
	}

	public List<Order> getAllOrders() { // for Admin
	    return orderjpa.findAll();
	}
	
	
	
	
	public Order updateOrderStatus(Long orderId, OrderStatus status) {
	    Order order = orderjpa.findById(orderId)
	            .orElseThrow(() -> new RuntimeException("Order not found"));
	    order.setStatus(status);
	    return orderjpa.save(order);
	}
	
	
	public Order cancelOrder(Long orderId) {
	    Order order = orderjpa.findById(orderId)
	            .orElseThrow(() -> new RuntimeException("Order not found"));

	    if (order.getStatus() == OrderStatus.PENDING) {
	        order.setStatus(OrderStatus.CANCELLED);
	        return orderjpa.save(order);
	    } else {
	        throw new RuntimeException("Order cannot be cancelled now!");
	    }
	}
}
