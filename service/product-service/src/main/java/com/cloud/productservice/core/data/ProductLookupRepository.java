package com.cloud.productservice.core.data;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProductLookupRepository extends JpaRepository<ProductLookupEntity, UUID> {

    ProductLookupEntity findByProductIdOrTitle(UUID productId, String title);
}
