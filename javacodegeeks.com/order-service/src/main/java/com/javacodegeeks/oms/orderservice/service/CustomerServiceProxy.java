package com.javacodegeeks.oms.orderservice.service;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "permissions-service", url = "localhost:8000")
public interface CustomerServiceProxy {
}