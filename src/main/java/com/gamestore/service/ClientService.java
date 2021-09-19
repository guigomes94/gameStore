package com.gamestore.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.gamestore.model.Client;
import com.gamestore.repository.ClientRepository;
import com.gamestore.service.exceptions.ResourceNotFoundException;

@Service
public class ClientService {
	
	@Autowired
	private ClientRepository repository;
	
	@Autowired
	private PasswordEncoder encoder;
	
	public List<Client> findAll() {
		return repository.findAll();
	}
	
	public Client findById(Long id) {
		return repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public Optional<Client> findByEmail(String email) {
		try {
			Optional<Client> entity = repository.findByEmail(email);
			return entity;
			
		} catch(EntityNotFoundException e) {
			throw new ResourceNotFoundException(email);
		}
	}
	
	public Client insert(Client obj) {
		obj.setPassword(encoder.encode(obj.getPassword()));
		return repository.save(obj);
	}
	
	public Client update(Long id, Client obj) {
		try {
			Optional<Client> entity = repository.findById(id);
			updateData(entity.get(), obj);
			return repository.save(entity.get());
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}
	
	private void updateData(Client entity, Client obj) {
		// falta implementar
	}

}
