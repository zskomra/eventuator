package com.cloud.orderservice.query;

import com.cloud.orderservice.core.data.OrderEntity;
import com.cloud.orderservice.core.data.OrdersRepository;
import com.cloud.orderservice.core.events.OrderCreatedEvent;
import lombok.RequiredArgsConstructor;
import org.axonframework.config.ProcessingGroup;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.stereotype.Component;

@Component
@ProcessingGroup("order-group")
@RequiredArgsConstructor
public class OrderEventsHandler {

    private final OrdersRepository ordersRepository;

    @EventHandler
    public void on(OrderCreatedEvent event) {
        OrderEntity orderEntity = OrderEntity.builder()
                .orderId(event.getOrderId())
                .productId(event.getProductId())
                .quantity(event.getQuantity())
                .orderStatus(event.getOrderStatus())
                .addressId(event.getAddressId())
                .userId(event.getUserId())
                .build();
        ordersRepository.save(orderEntity);
    }
}
