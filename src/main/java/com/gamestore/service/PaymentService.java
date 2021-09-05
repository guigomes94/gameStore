package com.gamestore.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gamestore.model.Payment;
import com.gamestore.repository.PaymentRepository;
import com.gamestore.service.exceptions.ResourceNotFoundException;

@Service
public class PaymentService {
	
	@Autowired
	private PaymentRepository repository;
	
	public List<Payment> findAll() {
		return repository.findAll();
	}
	
	public Payment findById(Long id) {
		return repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException(id));
	}	 
	
	public Payment insert(Payment obj) {
		return repository.save(obj);
	}
	
	public Payment update(Long id, Payment obj) {
		try {
			Optional<Payment> entity = repository.findById(id);
			updateData(entity.get(), obj);
			return repository.save(entity.get());
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}
	
	private void updateData(Payment entity, Payment obj) {
		// falta implementar
	}
}
