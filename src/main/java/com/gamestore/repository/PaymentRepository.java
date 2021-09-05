package com.gamestore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gamestore.model.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Long>{

}
