package com.cloud.productservice.command.rest;

import com.cloud.productservice.command.CreateProductCommand;
import lombok.RequiredArgsConstructor;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductCommandController {

    private final Environment environment;
    private final CommandGateway commandGateway;

    @PostMapping
    public String createProduct(@Valid @RequestBody CreateProductRestModel produceRestModel) {
        CreateProductCommand productCommand = CreateProductCommand.builder()
                .price(produceRestModel.getPrice())
                .quantity(produceRestModel.getQuantity())
                .title(produceRestModel.getTitle())
                .productId(UUID.randomUUID())
                .build();

        String returnValue;
        returnValue = commandGateway.sendAndWait(productCommand).toString();

//        try {
//            returnValue = commandGateway.sendAndWait(productCommand).toString();
//        }catch (Exception ex) {
//            returnValue = ex.getLocalizedMessage();
//        }
        return returnValue;
    }

}
