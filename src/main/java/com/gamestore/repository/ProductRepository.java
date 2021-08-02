package com.gamestore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gamestore.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

}
