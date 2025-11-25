package com.devendra.onlineshoppingapplication.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data 
@Table(name = "payment_razorpay")
@NoArgsConstructor
public class PaymentRazorpay  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String razorpayOrderId;
    private String razorpayPaymentId;

    @Enumerated(EnumType.STRING)
    private PaymentRazorpayStatus status;   // CREATED, PAID, FAILED

    private Double amount;

    private String currency;   // "INR"
    private String razorpaySignature;
    private String receipt;

    private LocalDateTime createdAt;

    @ManyToOne
    private Order order;
}
