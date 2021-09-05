package com.gamestore.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gamestore.model.City;
import com.gamestore.repository.CityRepository;
import com.gamestore.service.exceptions.ResourceNotFoundException;

@Service
public class CityService {
	
	@Autowired
	private CityRepository repository;
	
	public List<City> findAll() {
		return repository.findAll();
	}
	
	public City findById(Long id) {
		return repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException(id));
	}	 
	
	public City insert(City obj) {
		return repository.save(obj);
	}
	
	public City update(Long id, City obj) {
		try {
			Optional<City> entity = repository.findById(id);
			updateData(entity.get(), obj);
			return repository.save(entity.get());
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}
	
	private void updateData(City entity, City obj) {
		// falta implementar
	}
}
