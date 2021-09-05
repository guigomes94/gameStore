package com.gamestore.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gamestore.model.ItemOrder;
import com.gamestore.model.ItemOrderDTO;
import com.gamestore.model.Order;
import com.gamestore.model.Product;
import com.gamestore.repository.ItemOrderRepository;
import com.gamestore.repository.OrderRepository;
import com.gamestore.repository.ProductRepository;
import com.gamestore.service.exceptions.ResourceNotFoundException;

@Service
public class OrderService {
	
	@Autowired
	private OrderRepository repository;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private ItemOrderRepository itemOrderRepository;
	
	public List<Order> findAll() {
		return repository.findAll();
	}
	
	public Order findById(Long id) {
		return repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException(id));
	}	 
	
	public Order insert(Order obj) {
		obj.setInstant(LocalDateTime.now());
		return repository.save(obj);
	}
	
	public Order update(Long id, Order obj) {
		try {
			Optional<Order> entity = repository.findById(id);
			updateData(entity.get(), obj);
			return repository.save(entity.get());
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}
	
	private void updateData(Order entity, Order obj) {
		// falta implementar
	}
	
	public void insertItem(ItemOrderDTO item, Long orderId) {
		Order order = findById(orderId);
		Optional<Product> addItem = productRepository.findById(item.getProductId());
		if (addItem.get() != null) {
				Product p = addItem.get();
				itemOrderRepository.save(new ItemOrder(order, p, p.getSellPrice(), item.getQuantity()));
			} else {
				throw new ResourceNotFoundException(item.getProductId());
			}
		
	}
}
