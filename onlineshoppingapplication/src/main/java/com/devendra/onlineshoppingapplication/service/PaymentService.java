package com.devendra.onlineshoppingapplication.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devendra.onlineshoppingapplication.dao.PaymentDAO;
import com.devendra.onlineshoppingapplication.entity.Payment;

@Service
public class PaymentService {
	 
	@Autowired
	private PaymentDAO paymentdao;
	
	public Payment makePayment(Long orderId, double amount, String method) {
		return paymentdao.makePayment(orderId, amount, method);
	 }

}
