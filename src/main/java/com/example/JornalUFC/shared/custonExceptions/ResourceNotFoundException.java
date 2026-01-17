package com.example.JornalUFC.shared.custonExceptions;

import org.springframework.http.HttpStatus;

public class ResourceNotFoundException extends RuntimeException {

    private final String field;
    private final HttpStatus status;

    public ResourceNotFoundException(String field, String message) {
        super(message);
        this.field = field;
        this.status = HttpStatus.NOT_FOUND;
    }

    public String getField() {
        return field;
    }

    public HttpStatus getStatus() {
        return status;
    }
}
