package com.cloud.orderservice.core;

import com.cloud.orderservice.command.CreateOrderCommand;
import com.cloud.orderservice.command.OrderStatus;
import com.cloud.orderservice.core.events.OrderCreatedEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

@Aggregate
public class OrderAggregate {

    @AggregateIdentifier
    private String orderId;
    private String productId;
    private String userId;
    private int quantity;
    private String addressId;
    private OrderStatus orderStatus;

    public OrderAggregate() {
    }

    @CommandHandler
    public OrderAggregate(CreateOrderCommand orderCommand){
        OrderCreatedEvent orderCreatedEvent = OrderCreatedEvent.builder()
                .orderStatus(orderCommand.getOrderStatus())
                .orderId(orderCommand.getOrderId())
                .addressId(orderCommand.getAddressId())
                .quantity(orderCommand.getQuantity())
                .productId(orderCommand.getProductId())
                .userId(orderCommand.getUserId())
                .build();

        AggregateLifecycle.apply(orderCreatedEvent);
    }
    @EventSourcingHandler
    public void on(OrderCreatedEvent orderCreatedEvent){
        this.orderId = orderCreatedEvent.getOrderId();
        this.quantity = orderCreatedEvent.getQuantity();
        this.productId = orderCreatedEvent.getProductId();
        this.orderStatus = orderCreatedEvent.getOrderStatus();
        this.userId = orderCreatedEvent.getUserId();
        this.addressId = orderCreatedEvent.getAddressId();
    }
}
