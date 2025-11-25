package com.devendra.onlineshoppingapplication.dao;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.devendra.onlineshoppingapplication.entity.Cart;
import com.devendra.onlineshoppingapplication.entity.CartItem;
import com.devendra.onlineshoppingapplication.entity.Order;
import com.devendra.onlineshoppingapplication.entity.OrderItem;
import com.devendra.onlineshoppingapplication.entity.OrderStatus;
import com.devendra.onlineshoppingapplication.repository.CartJPARepository;
import com.devendra.onlineshoppingapplication.repository.OrderJPARepository;

@Repository
public class OrderDAO {
	
	@Autowired
	private OrderJPARepository orderjpa;
	
	@Autowired
	private CartJPARepository cartjpa;
	
//	public  String AddOrder(Order orders) {
//		ojpa.save(orders);
//		return "Order Added...";
//	}
	
//	public Optional<Order> findOderUsingId(long id) {
//		return ojpa.findById(id);
//	}
	
//	public List<Order> getOrdersByUser(Long userId) {
//	    return orderjpa.findByUserId(userId);
//	}
//
//	public List<Order> getAllOrders() { // for Admin
//	    return orderjpa.findAll();
//	}
	
	
	
	
//	public Order updateOrderStatus(Long orderId, OrderStatus status) {
//	    Order order = orderjpa.findById(orderId)
//	            .orElseThrow(() -> new RuntimeException("Order not found"));
//	    order.setStatus(status);
//	    return orderjpa.save(order);
//	}
	
	
//	public Order cancelOrder(Long orderId) {
//	    Order order = orderjpa.findById(orderId)
//	            .orElseThrow(() -> new RuntimeException("Order not found"));
//
//	    if (order.getStatus() == OrderStatus.PENDING) {
//	        order.setStatus(OrderStatus.CANCELLED);
//	        return orderjpa.save(order);
//	    } else {
//	        throw new RuntimeException("Order cannot be cancelled now!");
//	    }
//	}
	
	
//	public Order placeOrder(Long userId) {
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
//	    Order order2 = new Order();
//	    order2.setUser(cart.getUser());
//	    order2.setOrderDate(LocalDateTime.now());  // or LocalDateTime.now()
//	    order2.setStatus(OrderStatus.PENDING);   // ✅ default when placed
//
//
//	    return savedOrder;
//	}
	
	public Order placeOrder(Long userId) {
	    // 1. Get cart
	    Cart cart = cartjpa.findByUserId(userId);
	    if (cart == null) {
	        throw new RuntimeException("Cart not found for user: " + userId);
	    }

	    if (cart.getItems() == null || cart.getItems().isEmpty()) {
	        throw new RuntimeException("Cart is empty!");
	    }

	    // 2. Create order
	    Order order = new Order();
	    order.setUser(cart.getUser());
	    order.setOrderDate(LocalDateTime.now());
	    order.setStatus(OrderStatus.PENDING); // ✅ set default status

	    double totalPrice = 0.0;

	    // 3. Convert cart items → order items
	    List<OrderItem> orderItems = new ArrayList<>();
	    for (CartItem cartItem : cart.getItems()) {
	        OrderItem orderItem = new OrderItem();
	        orderItem.setProduct(cartItem.getProduct());
	        orderItem.setQuantity(cartItem.getQuantity());
	        orderItem.setPrice(cartItem.getPrice() * cartItem.getQuantity()); // ✅ consider quantity
	        orderItem.setOrder(order); // link back to order

	        orderItems.add(orderItem);

	        totalPrice += orderItem.getPrice(); // ✅ sum total amount
	    }

	    order.setItems(orderItems);
	    order.setTotalAmount(totalPrice);

	    // 4. Save order
	    Order savedOrder = orderjpa.save(order);

	    // 5. Clear cart
	    cart.getItems().clear();
	    cart.setTotalPrice(0.0);
	    cartjpa.save(cart);

	    return savedOrder;
	}

	
	public Order updateOrderStatus(Long orderId, OrderStatus status) {
	    Order order = orderjpa.findById(orderId)
	            .orElseThrow(() -> new RuntimeException("Order not found with id: " + orderId));

	    order.setStatus(status);
	    return orderjpa.save(order);
	}



	    public List<Order> getOrdersByUser(Long userId) {
	        return orderjpa.findByUserId(userId);
	    }

	    public List<Order> getAllOrders() { // for Admin
	        return orderjpa.findAll();
	    }
}
