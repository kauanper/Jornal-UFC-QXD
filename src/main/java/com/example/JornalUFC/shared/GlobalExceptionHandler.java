package com.example.JornalUFC.shared;

import com.example.JornalUFC.shared.custonExceptions.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorResponseDTO> handleResourceNotFound(ResourceNotFoundException ex) {

        ErrorResponseDTO error = new ErrorResponseDTO(
                ex.getField(),
                ex.getMessage(),
                ex.getStatus().value(),
                ex.getStatus().getReasonPhrase()
        );

        return ResponseEntity
                .status(ex.getStatus())
                .body(error);
    }

}
