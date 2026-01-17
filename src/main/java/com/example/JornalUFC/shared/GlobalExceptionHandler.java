package com.example.JornalUFC.shared;

import com.example.JornalUFC.shared.custonExceptions.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<ErrorResponseDTO>> handleValidationErrors(
            MethodArgumentNotValidException ex
    ) {

        List<ErrorResponseDTO> errors = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(this::toErrorResponse)
                .collect(Collectors.toList());

        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(errors);
    }

    private ErrorResponseDTO toErrorResponse(FieldError fieldError) {
        return new ErrorResponseDTO(
                fieldError.getField(),
                fieldError.getDefaultMessage(),
                HttpStatus.BAD_REQUEST.value(),
                HttpStatus.BAD_REQUEST.getReasonPhrase()
        );
    }

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
