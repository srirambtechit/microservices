package com.restaurant.orders.config;

import com.restaurant.orders.command.api.OrderItemsCommandsController;
import com.restaurant.orders.query.OrderItem;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.ResourceProcessor;
import org.springframework.hateoas.Resources;
import org.springframework.stereotype.Component;

import java.util.UUID;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@Component
public class OrderItemsNestedResourceProcessor implements ResourceProcessor<Resources<Resource<OrderItem>>> {

    @Override
    public Resources<Resource<OrderItem>> process(Resources<Resource<OrderItem>> resources) {
        String orderId = new ResourceURI(resources.getId().getHref()).getParentId();

        try {
            UUID.fromString(orderId);
            resources.add(linkTo(methodOn(OrderItemsCommandsController.class).getCommands(orderId))
                .withRel("commands").expand(orderId));
        } catch (Exception e) {}

        return resources;
    }
}

