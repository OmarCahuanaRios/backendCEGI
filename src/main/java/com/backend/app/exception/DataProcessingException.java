package com.backend.app.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.UNPROCESSABLE_ENTITY)
public class DataProcessingException extends RuntimeException {
    private String message;

    public DataProcessingException(String message) {
        super(message);
    }
}
