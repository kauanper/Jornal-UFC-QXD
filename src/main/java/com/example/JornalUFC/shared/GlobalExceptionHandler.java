package com.example.JornalUFC.shared;

import com.example.JornalUFC.shared.custonExceptions.DuplicateResourceException;
import com.example.JornalUFC.shared.custonExceptions.ResourceNotFoundException;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(DuplicateResourceException.class)
    public ResponseEntity<ErrorResponseDTO> handleDuplicateResource(
            DuplicateResourceException ex
    ) {
        ErrorResponseDTO error = new ErrorResponseDTO(
                ex.getField(),
                ex.getMessage(),
                ex.getStatus().value(),
                ex.getStatus().getReasonPhrase()
        );

        return ResponseEntity.status(ex.getStatus()).body(error);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ErrorResponseDTO> handleHttpMessageNotReadable(
            HttpMessageNotReadableException ex
    ) {

        String field = "request";
        String message = "JSON inválido";

        Throwable cause = ex.getCause();
        if (cause instanceof InvalidFormatException invalidFormatException) {

            Class<?> targetType = invalidFormatException.getTargetType();

            if (targetType.isEnum()) {
                field = invalidFormatException.getPath()
                        .stream()
                        .map(ref -> ref.getFieldName())
                        .findFirst()
                        .orElse("enum");

                String allowedValues = Arrays.toString(targetType.getEnumConstants());

                message = "Valor inválido para o campo '" + field +
                        "'. Valores aceitos: " + allowedValues;
            }
        }

        ErrorResponseDTO error = new ErrorResponseDTO(
                field,
                message,
                HttpStatus.BAD_REQUEST.value(),
                HttpStatus.BAD_REQUEST.getReasonPhrase()
        );

        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(error);
    }

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
