package com.example.JornalUFC.shared;

public record ErrorResponseDTO(String field, String message, Integer statusCode, String error) {
}
