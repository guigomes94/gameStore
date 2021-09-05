package com.gamestore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gamestore.model.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{

}
