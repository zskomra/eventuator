package com.cloud.productservice.query.rest;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.UUID;

@Builder
@Data
public class ProductRestModel {

    private UUID productId;
    private String title;
    private BigDecimal price;
    private Integer quantity;
}
