package com.devendra.onlineshoppingapplication.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devendra.onlineshoppingapplication.dao.OrderDAO;
import com.devendra.onlineshoppingapplication.entity.Cart;
import com.devendra.onlineshoppingapplication.entity.CartItem;
import com.devendra.onlineshoppingapplication.entity.Order;
import com.devendra.onlineshoppingapplication.entity.OrderItem;
import com.devendra.onlineshoppingapplication.entity.OrderStatus;

@Service
public class OrderService {
	
	@Autowired
	private OrderDAO orderdao;
	
//	public List<Order> getOrdersByUser(Long userId) {
//	    return orderdao.getOrdersByUser(userId);
//	}
//
//	public List<Order> getAllOrders() { // for Admin
//	    return orderdao.getAllOrders();
//	}
	
//	public Order updateOrderStatus(Long orderId, OrderStatus status) {
//		return orderdao.updateOrderStatus(orderId, status);
//	}	
//	
//	public Order cancelOrder(Long orderId) {
//		return orderdao.cancelOrder(orderId);
//	}
	
	public Order placeOrder(Long userId) {
		
		return orderdao.placeOrder(userId);
//	    // 1. Get cart
//	    Cart cart = cartjpa.findByUserId(userId);
//	    if (cart == null) {
//	        throw new RuntimeException("Cart not found for user: " + userId);
//	    }
//
//	    if (cart.getItems() == null || cart.getItems().isEmpty()) {
//	        throw new RuntimeException("Cart is empty!");
//	    }
//
//	    // 2. Create order
//	    Order order = new Order();
//	    order.setUser(cart.getUser());
////	    order.setOrderDate(new Date());
//	    order.setOrderDate(LocalDateTime.now());
//
//	    double totalPrice = 0.0;
//
//	    // 3. Convert cart items → order items
//	    List<OrderItem> orderItems = new ArrayList<OrderItem>();
//	    for (CartItem cartItem : cart.getItems()) {
//	        OrderItem orderItem = new OrderItem();
//	        orderItem.setProduct(cartItem.getProduct());
//	        orderItem.setQuantity(cartItem.getQuantity());
//	        orderItem.setPrice(cartItem.getPrice());
//	        orderItem.setOrder(order);
//
//	        orderItems.add(orderItem);
//	        totalPrice = totalPrice + cartItem.getPrice();
//	    }
//
//	    order.setItems(orderItems);
//	    order.setTotalAmount(totalPrice);
//
//	    // 4. Save order
//	    Order savedOrder = orderjpa.save(order);
//
//	    // 5. Clear cart
//	    cart.getItems().clear();
//	    cart.setTotalPrice(0.0);
//	    cartjpa.save(cart);
//
//	    return savedOrder;
	}


	    public List<Order> getOrdersByUser(Long userId) {
	        return orderdao.getOrdersByUser(userId);
	    }

	    public List<Order> getAllOrders() { // for Admin
	    	return orderdao.getAllOrders();
	    }


		public Order updateOrderStatus(Long orderId, OrderStatus status) {
			return orderdao.updateOrderStatus(orderId, status);
		}
}
