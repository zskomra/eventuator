package com.cloud.productservice.query;

import com.cloud.productservice.core.data.ProductEntity;
import com.cloud.productservice.core.data.ProductRepository;
import com.cloud.productservice.core.events.ProductCreatedEvent;
import org.axonframework.config.ProcessingGroup;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.stereotype.Component;

@Component
@ProcessingGroup("product-group")
public class ProductProjection {

    private final ProductRepository productRepository;

    public ProductProjection(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @EventHandler
    public void on(ProductCreatedEvent event) {
        ProductEntity productEntity = ProductEntity.builder()
                .productId(event.getProductId())
                .price(event.getPrice())
                .quantity(event.getQuantity())
                .title(event.getTitle())
                .build();
        productRepository.save(productEntity);

    }
}
