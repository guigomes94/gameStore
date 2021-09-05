package com.gamestore.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.gamestore.model.Payment;
import com.gamestore.service.PaymentService;

@RestController
@RequestMapping("/payments")
public class PaymentController {
	
	@Autowired
	private PaymentService service;
	
	@GetMapping
	public ResponseEntity<?> listAll() {
		List<Payment> response = service.findAll();
		return !response.isEmpty() ? ResponseEntity.ok(response) : ResponseEntity.noContent().build();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Payment> findOne(@PathVariable Long id) {
		Payment response = service.findById(id);
		return ResponseEntity.ok(response);
	}
	
	@PostMapping
	public ResponseEntity<?> create(@RequestBody Payment obj) {
		Payment saved = service.insert(obj);
		URI uri = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(saved.getId())
				.toUri();
		return ResponseEntity.created(uri).body(saved);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Payment obj) {
		Payment updated = service.update(id, obj);
		return updated != null ? ResponseEntity.ok(updated) : ResponseEntity.notFound().build();
	}

}
