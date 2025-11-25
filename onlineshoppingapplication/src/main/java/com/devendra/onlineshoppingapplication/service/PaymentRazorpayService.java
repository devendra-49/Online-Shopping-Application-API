package com.devendra.onlineshoppingapplication.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devendra.onlineshoppingapplication.dao.PaymentRazorpayDAO;
import com.devendra.onlineshoppingapplication.entity.PaymentRazorpay;
import com.devendra.onlineshoppingapplication.entity.PaymentRazorpayStatus;

@Service
public class PaymentRazorpayService {

    @Autowired
    private PaymentRazorpayDAO razorpayDAO;

    // Create Razorpay Order entry
    public PaymentRazorpay createRazorpayOrder(Long orderId, String razorpayOrderId, Double amount, String receipt) {
        return razorpayDAO.saveRazorpayOrder(orderId, razorpayOrderId, amount, receipt);
    }

    // Update Razorpay Payment after user pays
    public PaymentRazorpay updatePayment(String razorpayPaymentId, String signature, PaymentRazorpayStatus status) {
        return razorpayDAO.updatePaymentStatus(razorpayPaymentId, signature, status);
    }

    // Get payment using orderId
    public PaymentRazorpay getPaymentByOrder(Long orderId) {
        return razorpayDAO.getPaymentByOrderId(orderId);
    }
}
