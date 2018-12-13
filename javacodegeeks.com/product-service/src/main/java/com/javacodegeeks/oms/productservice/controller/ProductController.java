package com.javacodegeeks.oms.productservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.javacodegeeks.oms.productservice.domain.Product;
import com.javacodegeeks.oms.productservice.repository.ProductRepository;

@RestController
public class ProductController {

	private ProductRepository productRepository;

	@Autowired
	public ProductController(ProductRepository productRepository) {
		super();
		this.productRepository = productRepository;
	}

	@GetMapping("/products")
	public List<Product> getProducts() {
		return productRepository.findAll();
	}

	@PostMapping("/products")
	public Product save(@RequestBody Product product) {
		return productRepository.save(product);
	}
}
