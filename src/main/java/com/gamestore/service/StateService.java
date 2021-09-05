package com.gamestore.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gamestore.model.State;
import com.gamestore.repository.StateRepository;
import com.gamestore.service.exceptions.ResourceNotFoundException;

@Service
public class StateService {
	
	@Autowired
	private StateRepository repository;
	
	public List<State> findAll() {
		return repository.findAll();
	}
	
	public State findById(Long id) {
		return repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException(id));
	}	 
	
	public State insert(State obj) {
		return repository.save(obj);
	}
	
	public State update(Long id, State obj) {
		try {
			Optional<State> entity = repository.findById(id);
			updateData(entity.get(), obj);
			return repository.save(entity.get());
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}
	
	private void updateData(State entity, State obj) {
		// falta implementar
	}
}
