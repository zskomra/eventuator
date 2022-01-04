package com.cloud.orderservice.core.events;

import com.cloud.orderservice.command.OrderStatus;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OrderCreatedEvent {
    private String orderId;
    private String productId;
    private String userId;
    private int quantity;
    private String addressId;
    private OrderStatus orderStatus;
}
