package com.cloud.productservice.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductsController {

    @Autowired
    private Environment environment;

    @PostMapping
    public String createProduct() {
        return "HTTP post handled";
    }

    @GetMapping
    public String getProduct() {
        return "server port: " + environment.getProperty("local.server.port");
    }
}
