package com.cloud.productservice.core.data;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProductRepository extends JpaRepository<ProductEntity, UUID> {

    ProductEntity findByProductId(UUID productId);
    ProductEntity findByProductId(String productId);
    ProductEntity findByProductIdOrTitle(UUID productId, String title);
}
