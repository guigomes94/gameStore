package com.gamestore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gamestore.model.ItemOrder;

public interface ItemOrderRepository extends JpaRepository<ItemOrder, Long> {

}
