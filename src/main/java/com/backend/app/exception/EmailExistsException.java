package com.backend.app.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.FOUND)
public class EmailExistsException extends RuntimeException {
    private String message;

    public EmailExistsException(String message) {
        super(message);
    }
}
