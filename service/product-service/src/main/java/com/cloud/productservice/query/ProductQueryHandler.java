package com.cloud.productservice.query;

import com.cloud.productservice.core.data.ProductEntity;
import com.cloud.productservice.core.data.ProductRepository;
import com.cloud.productservice.query.rest.ProductRestModel;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductQueryHandler {

    private final ProductRepository productRepository;

    public ProductQueryHandler(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @QueryHandler
    public List<ProductRestModel> findProducts(FindProductsQuery findProductsQuery) {
        List<ProductRestModel> products = new ArrayList<>();
        List<ProductEntity> storedProducts = productRepository.findAll();
        for(ProductEntity productEntity :storedProducts) {
            ProductRestModel productRestModel = ProductRestModel.builder()
                    .productId(productEntity.getProductId())
                    .price(productEntity.getPrice())
                    .quantity(productEntity.getQuantity())
                    .title(productEntity.getTitle())
                    .build();
            products.add(productRestModel);
        }
        return products;
    }
}
