package com.rolon.microservices.products.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

}
