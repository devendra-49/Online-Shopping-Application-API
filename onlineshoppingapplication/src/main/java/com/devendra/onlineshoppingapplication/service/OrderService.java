package com.devendra.onlineshoppingapplication.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devendra.onlineshoppingapplication.dao.OrderDAO;
import com.devendra.onlineshoppingapplication.entity.Order;
import com.devendra.onlineshoppingapplication.entity.OrderStatus;

@Service
public class OrderService {
	
	@Autowired
	private OrderDAO orderdao;
	
	public List<Order> getOrdersByUser(Long userId) {
	    return orderdao.getOrdersByUser(userId);
	}

	public List<Order> getAllOrders() { // for Admin
	    return orderdao.getAllOrders();
	}
	
	public Order updateOrderStatus(Long orderId, OrderStatus status) {
		return orderdao.updateOrderStatus(orderId, status);
	}	
	
	public Order cancelOrder(Long orderId) {
		return orderdao.cancelOrder(orderId);
	}


}
