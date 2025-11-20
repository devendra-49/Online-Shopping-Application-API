package com.devendra.onlineshoppingapplication.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "payments")
@NoArgsConstructor
public class Payment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private double amount;
	@Enumerated(EnumType.STRING) 
	private PaymentStatus status; // PENDING, SUCCESS, FAILED
	private String method; // UPI, CARD, COD, WALLET, etc.
    private LocalDateTime paymentDate;
    @OneToOne
	@JoinColumn(name = "order_id")
	private Order order;
}
