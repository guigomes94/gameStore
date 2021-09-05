package com.gamestore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gamestore.model.Address;

public interface AddressRepository extends JpaRepository<Address, Long>{

}
