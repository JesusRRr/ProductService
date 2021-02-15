package com.rolon.microservices.products.model.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rolon.microservices.products.model.entity.Product;
import com.rolon.microservices.products.model.repository.ProductRepository;

@Service
public class ProductServiceImpl implements IProductService{

	@Autowired
	private ProductRepository productoRepository;
	
	@Override
	@Transactional(readOnly= true)
	public List<Product> findAll() {
		return (List<Product>) productoRepository.findAll();
	}

	@Override
	@Transactional(readOnly= true)
	public Product findById(Long id) {
		return productoRepository.findById(id).orElse(null);
	}
	
	@Override
	@Transactional(readOnly= true)
	public String deleteById(Long id) {
		Product product = findById(id);
		ObjectMapper objectMapper = new ObjectMapper();
		Map<String, String> map = new HashMap();
		String message = new StringBuilder(product.getName())
				.append(" deleted")
				.toString();
		
		map.put("message", message);
		try {
			return objectMapper.writeValueAsString(map);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			return null;
		}

	}
}
