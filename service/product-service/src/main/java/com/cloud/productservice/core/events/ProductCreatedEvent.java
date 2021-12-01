package com.cloud.productservice.core.events;

import lombok.Builder;
import lombok.Data;
import java.math.BigDecimal;
import java.util.UUID;

@Data
@Builder
public class ProductCreatedEvent {

    private UUID productId;
    private String title;
    private BigDecimal price;
    private Integer quantity;
}
