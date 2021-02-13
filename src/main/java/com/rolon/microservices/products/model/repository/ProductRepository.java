package com.rolon.microservices.products.model.repository;

import org.springframework.data.repository.CrudRepository;

import com.rolon.microservices.products.model.entity.Product;

public interface ProductRepository extends CrudRepository<Product, Long>{

}
