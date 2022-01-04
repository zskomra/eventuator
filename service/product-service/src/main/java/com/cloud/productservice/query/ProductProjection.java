package com.cloud.productservice.query;

import com.cloud.productservice.core.data.ProductEntity;
import com.cloud.productservice.core.data.ProductRepository;
import com.cloud.productservice.core.events.ProductCreatedEvent;
import org.axonframework.config.ProcessingGroup;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.messaging.interceptors.ExceptionHandler;
import org.springframework.stereotype.Component;

@Component
@ProcessingGroup("product-group")
public class ProductProjection {

    private final ProductRepository productRepository;

    public ProductProjection(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @ExceptionHandler(resultType = Exception.class)
    public void handle(Exception exception) throws Exception {
        throw exception;
    }

    @ExceptionHandler(resultType = IllegalArgumentException.class)
    public void handle(IllegalArgumentException exception) {
        //log error message
    }

    @EventHandler
    public void on(ProductCreatedEvent event) throws Exception {
        ProductEntity productEntity = ProductEntity.builder()
                .productId(event.getProductId())
                .price(event.getPrice())
                .quantity(event.getQuantity())
                .title(event.getTitle())
                .build();
        try {
            productRepository.save(productEntity);
        }
        catch (IllegalArgumentException ex) {
            ex.printStackTrace();
        }

        if(true) throw  new Exception("Forcing exception in the Event Handler class");

    }
}
