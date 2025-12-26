package com.devendra.onlineshoppingapplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.devendra.onlineshoppingapplication.entity.PaymentRazorpay;
import com.devendra.onlineshoppingapplication.entity.PaymentRazorpayStatus;
import com.devendra.onlineshoppingapplication.service.PaymentRazorpayService;

@RestController
@RequestMapping("/api/razorpay")
public class PaymentRazorpayController {

    @Autowired
    private PaymentRazorpayService paymentService;

    
    // 	 1. Create Razorpay Order
    @PostMapping("/create-order")
    public PaymentRazorpay createOrder(
            @RequestParam Long orderId,
            @RequestParam String razorpayOrderId,
            @RequestParam Double amount,
            @RequestParam String receipt) {

        return paymentService.createRazorpayOrder(orderId, razorpayOrderId, amount, receipt);
    }


    //  2. Update Razorpay payment (after user pays)
    @PutMapping("/update-payment")
    public PaymentRazorpay updatePayment(
            @RequestParam String razorpayPaymentId,	
            @RequestParam String signature,
            @RequestParam PaymentRazorpayStatus status) {

        return paymentService.updatePayment(razorpayPaymentId, signature, status);
    }


    //  3. Get Payment Details for Order
    @GetMapping("/order/{orderId}")
    public PaymentRazorpay getPaymentByOrder(@PathVariable Long orderId) {
        return paymentService.getPaymentByOrder(orderId);
    }
}
