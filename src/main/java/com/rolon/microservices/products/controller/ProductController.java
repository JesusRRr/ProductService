package com.rolon.microservices.products.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.rolon.microservices.products.model.entity.Product;
import com.rolon.microservices.products.model.service.IProductService;

@RestController
public class ProductController {
	
	@Autowired
	private IProductService productService;
	
	@GetMapping("/list")
	public List<Product> list(){
		return productService.findAll();
	}
	
	@GetMapping("/list/{id}")
	public Product getDetails(@PathVariable Long id) {
		return productService.findById(id);
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteProduct(@PathVariable Long id) {
		return productService.deleteById(id);
	}
	
	@PostMapping("/save")
	public Product uploadProduct(@RequestBody Product product) {
		return productService.insert(product);
	}
	
	@PutMapping("/update/{id}")
	public Product updteProduct(@PathVariable Long id, @RequestBody Product product) {
		return productService.update(id, product);
	}
}
