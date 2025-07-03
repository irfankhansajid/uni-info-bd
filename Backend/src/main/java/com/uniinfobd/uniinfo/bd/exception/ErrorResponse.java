package com.uniinfobd.uniinfo.bd.exception;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor

public class ErrorResponse {
  
  private int status;
  private String message;
  private List<String> errors;
  private String timestamp;

  public ErrorResponse(int status, String message, List<String> errors, String timestamp) {
    this.status = status;
    this.message = message;
    this.errors = errors;
    this.timestamp = timestamp;
  }
}
