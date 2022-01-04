package com.cloud.productservice.core.errorhandling;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.Instant;

@Data
@AllArgsConstructor
public class ErrorMessage {

    private final Instant timeStamp;
    private final String message;
}
