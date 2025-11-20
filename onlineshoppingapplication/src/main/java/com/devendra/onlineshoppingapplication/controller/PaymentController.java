package com.devendra.onlineshoppingapplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.devendra.onlineshoppingapplication.entity.Payment;
import com.devendra.onlineshoppingapplication.service.PaymentService;

@RestController
@RequestMapping("/api")
public class PaymentController {
	
	@Autowired 
	private PaymentService paymentservice;  
	
	@PostMapping("/pay/{orderId}")
    public Payment pay(@PathVariable Long orderId,  
                       @RequestParam double amount, 
                       @RequestParam String method) {
        return paymentservice.makePayment(orderId, amount, method);
    }

}
