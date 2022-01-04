package com.cloud.orderservice.command.rest;

import lombok.Data;

@Data
public class CreateOrderRestModel {

    private String productId;
    private int quantity;
    private String addressId;

}
