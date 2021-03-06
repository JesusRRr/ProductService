package com.rolon.microservices.products.model.service;

import java.util.List;

import com.rolon.microservices.products.model.entity.Product;

public interface IProductService {
	
	public List<Product> findAll();
	public Product findById(Long id);
	public String deleteById(Long id);
	public Product insert(Product product);
	public Product update(Long id, Product product);
}
