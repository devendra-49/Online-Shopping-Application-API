package com.devendra.onlineshoppingapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devendra.onlineshoppingapplication.entity.Payment;

public interface PaymentJPARepository extends JpaRepository<Payment, Long>{

}
