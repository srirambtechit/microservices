package com.javacodegeeks.oms.productservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javacodegeeks.oms.productservice.domain.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
