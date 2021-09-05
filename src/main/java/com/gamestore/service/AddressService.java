package com.gamestore.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gamestore.model.Address;
import com.gamestore.repository.AddressRepository;
import com.gamestore.service.exceptions.ResourceNotFoundException;

@Service
public class AddressService {
	
	@Autowired
	private AddressRepository repository;
	
	public List<Address> findAll() {
		return repository.findAll();
	}
	
	public Address findById(Long id) {
		return repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException(id));
	}	 
	
	public Address insert(Address obj) {
		return repository.save(obj);
	}
	
	public Address update(Long id, Address obj) {
		try {
			Optional<Address> entity = repository.findById(id);
			updateData(entity.get(), obj);
			return repository.save(entity.get());
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}
	
	private void updateData(Address entity, Address obj) {
		// falta implementar
	}
}
