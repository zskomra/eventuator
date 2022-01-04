package com.cloud.orderservice.command.rest;

import com.cloud.orderservice.command.CreateOrderCommand;
import com.cloud.orderservice.command.OrderStatus;
import lombok.RequiredArgsConstructor;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrdersCommandController {

    private final CommandGateway commandGateway;
    static String USER_ID = "27b95829-4f3f-4ddf-8983-151ba010e35b";

    @PostMapping
    public String createOrder(@RequestBody CreateOrderRestModel order){
        CreateOrderCommand command = CreateOrderCommand.builder()
                .orderId(UUID.randomUUID().toString())
                .userId(USER_ID)
                .quantity(order.getQuantity())
                .productId(order.getProductId())
                .addressId(order.getAddressId())
                .orderStatus(OrderStatus.CREATED)
                .build();
        String returnValue;
        returnValue = commandGateway.sendAndWait(command).toString();
        return returnValue;
    }
}
