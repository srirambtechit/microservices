package com.javacodegeeks.oms.orderservice.dto.request;

import java.math.BigDecimal;

import lombok.Getter;

@Getter
public class Item {
    private Long productId;
    private BigDecimal quantity;
}