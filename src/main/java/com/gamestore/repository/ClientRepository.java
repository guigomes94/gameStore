package com.gamestore.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gamestore.model.Client;

public interface ClientRepository extends JpaRepository<Client, Long>{
	
	public Optional<Client> findByEmail(String email);

}
