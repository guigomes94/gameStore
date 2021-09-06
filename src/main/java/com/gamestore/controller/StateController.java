package com.gamestore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gamestore.model.State;
import com.gamestore.service.StateService;

@RestController
@RequestMapping("/states")
public class StateController {
	
	@Autowired
	private StateService service;
	
	@GetMapping
	public ResponseEntity<?> listAll() {
		List<State> response = service.findAll();
		return !response.isEmpty() ? ResponseEntity.ok(response) : ResponseEntity.noContent().build();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<State> findOne(@PathVariable Long id) {
		State response = service.findById(id);
		return ResponseEntity.ok(response);
	}

}
