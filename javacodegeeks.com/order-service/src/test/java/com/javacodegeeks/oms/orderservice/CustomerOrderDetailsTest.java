package com.javacodegeeks.oms.orderservice;

import java.util.Arrays;

import org.junit.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.javacodegeeks.oms.orderservice.dto.customer.Address;
import com.javacodegeeks.oms.orderservice.dto.customer.Customer;
import com.javacodegeeks.oms.orderservice.dto.order.CustomerOrderDetails;
import com.javacodegeeks.oms.orderservice.dto.product.Product;

public class CustomerOrderDetailsTest {

    @Test
    public void test() throws JsonProcessingException {
        final CustomerOrderDetails customer = CustomerOrderDetails.builder()
                .orderId(1234L)
                .externalReference("234257hf")
                .customer(Customer.builder()
                        .firstName("sriram")
                        .lastName("muthaiah")
                        .address(Address.builder().addressLine1("123")
                                .city("Chennai")
                                .country("India").build())
                        .email("test@test.com").build())
                .items(Arrays.asList(
                        com.javacodegeeks.oms.orderservice.dto.product.Item.builder()
                                .product(Product
                                        .builder()
                                        .name("Nike Shoes")
                                        .description("Mens shoes")
                                        .sku("1234")
                                        .price("100").build()).build()))
                .build();
        ObjectMapper o = new ObjectMapper();
        System.out.println(o.writeValueAsString(customer));

    }
}