package com.javacodegeeks.oms.orderservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javacodegeeks.oms.orderservice.domain.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
	List<Order> findByCustomerId(String customerId);
}