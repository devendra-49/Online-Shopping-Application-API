package com.devendra.onlineshoppingapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.devendra.onlineshoppingapplication.entity.PaymentRazorpay;

public interface PaymentRazorpayJPARepository extends JpaRepository<PaymentRazorpay, Long> {

    PaymentRazorpay findByRazorpayOrderId(String razorpayOrderId);

    PaymentRazorpay findByRazorpayPaymentId(String razorpayPaymentId);
}
