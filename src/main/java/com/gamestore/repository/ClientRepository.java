package com.gamestore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gamestore.model.Client;

public interface ClientRepository extends JpaRepository<Client, Long>{

}
