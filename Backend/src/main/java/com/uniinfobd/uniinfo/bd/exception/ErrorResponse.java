package com.uniinfobd.uniinfo.bd.exception;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorResponse {
  
  private int status;
  private String message;
  private List<String> errors;
  private String timestamp;

}
