package com.javacodegeeks.oms.orderservice.dto.request;

import java.time.LocalDateTime;
import java.util.List;

import lombok.Getter;

@Getter
public class CustomerOrderRequest {
    private String customerId;
    private String externalReference;
    private LocalDateTime createdDate;
    private List<Item> items;
}