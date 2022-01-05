package com.cloud.core.events;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductReservedEvent {
    private String productId;
    private String orderId;
    private Integer quantity;
    private String userId;
}
