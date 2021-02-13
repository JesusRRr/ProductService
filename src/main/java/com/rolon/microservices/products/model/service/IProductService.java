package com.rolon.microservices.products.model.service;

import java.util.List;

import com.rolon.microservices.products.model.entity.Product;

public interface IProductService {
	
	public List<Product> findAll();
	public Product findById(Long id);
}
