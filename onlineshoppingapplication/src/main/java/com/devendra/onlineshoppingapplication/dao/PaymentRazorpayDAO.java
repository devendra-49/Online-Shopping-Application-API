package com.devendra.onlineshoppingapplication.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.devendra.onlineshoppingapplication.entity.Order;
import com.devendra.onlineshoppingapplication.entity.PaymentRazorpay;
import com.devendra.onlineshoppingapplication.entity.PaymentRazorpayStatus;
import com.devendra.onlineshoppingapplication.repository.OrderJPARepository;
import com.devendra.onlineshoppingapplication.repository.PaymentRazorpayJPARepository;

@Repository
public class PaymentRazorpayDAO {

    @Autowired
    private PaymentRazorpayJPARepository razorpayRepo;

    @Autowired
    private OrderJPARepository orderRepo;

    // Save Razorpay Order created
    public PaymentRazorpay saveRazorpayOrder(Long orderId, String razorpayOrderId, Double amount, String receipt) {

        Order order = orderRepo.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order not found"));

        PaymentRazorpay payment = new PaymentRazorpay();
        payment.setOrder(order);
        payment.setAmount(amount);
        payment.setRazorpayOrderId(razorpayOrderId);
        payment.setStatus(PaymentRazorpayStatus.CREATED);
        payment.setReceipt(receipt);
        payment.setCurrency("INR");

        return razorpayRepo.save(payment);
    }

    // Update Razorpay payment when user pays
    public PaymentRazorpay updatePaymentStatus(String razorpayPaymentId, String signature, PaymentRazorpayStatus status) {

        PaymentRazorpay payment = razorpayRepo.findByRazorpayPaymentId(razorpayPaymentId);

        if (payment == null) {
            throw new RuntimeException("Razorpay payment not found: " + razorpayPaymentId);
        }

        payment.setRazorpayPaymentId(razorpayPaymentId);
        payment.setRazorpaySignature(signature);
        payment.setStatus(status);

        return razorpayRepo.save(payment);
    }

    // Get Payment by Order Id
    public PaymentRazorpay getPaymentByOrderId(Long orderId) {
        return razorpayRepo.findAll()
                .stream()
                .filter(p -> p.getOrder().getId() == orderId)
                .findFirst()
                .orElse(null);
    }
}
