package com.example.JornalUFC.shared.custonExceptions;

import org.springframework.http.HttpStatus;

public class DuplicateResourceException extends RuntimeException {

  private final String field;
  private final HttpStatus status;

  public DuplicateResourceException(String field, String message) {
    super(message);
    this.field = field;
    this.status = HttpStatus.CONFLICT;
  }

  public String getField() {
    return field;
  }

  public HttpStatus getStatus() {
    return status;
  }
}
