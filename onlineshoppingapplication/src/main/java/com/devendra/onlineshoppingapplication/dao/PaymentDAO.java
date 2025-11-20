package com.devendra.onlineshoppingapplication.dao;

import java.time.LocalDateTime;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.devendra.onlineshoppingapplication.entity.Order;
import com.devendra.onlineshoppingapplication.entity.OrderStatus;
import com.devendra.onlineshoppingapplication.entity.Payment;
import com.devendra.onlineshoppingapplication.entity.PaymentStatus;
import com.devendra.onlineshoppingapplication.repository.OrderJPARepository;
import com.devendra.onlineshoppingapplication.repository.PaymentJPARepository;

@Repository
public class PaymentDAO {
	
	@Autowired
	private PaymentJPARepository paymentjpa;
	
	@Autowired
	private OrderJPARepository orderjpa;
	
	 public Payment makePayment(Long orderId, double amount, String method) {
	        Order order = orderjpa.findById(orderId)
	                .orElseThrow(() -> new RuntimeException("Order not found"));

	        Payment payment = new Payment();
	        payment.setOrder(order);
	        payment.setAmount(amount);
	        payment.setMethod(method);
	        payment.setPaymentDate(LocalDateTime.now());
	        payment.setStatus(PaymentStatus.SUCCESS); // for now we assume success

	        Payment savedPayment = paymentjpa.save(payment);
            
	        // update order status if payment is successful
	        if (savedPayment.getStatus() == PaymentStatus.SUCCESS) {
	            order.setStatus(OrderStatus.SHIPPED);
	            orderjpa.save(order);
	        }

	        return savedPayment;
	    }
}
