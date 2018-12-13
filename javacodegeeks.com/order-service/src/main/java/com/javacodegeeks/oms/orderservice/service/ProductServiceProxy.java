package com.javacodegeeks.oms.orderservice.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.javacodegeeks.oms.orderservice.dto.product.Product;

@FeignClient(name = "product-service", url = "localhost:8001")
public interface ProductServiceProxy {

    @GetMapping("/products/{id}")
    Product getProduct(@PathVariable("id") Long id);
}