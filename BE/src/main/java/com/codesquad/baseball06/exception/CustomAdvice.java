package com.codesquad.baseball06.exception;

import com.codesquad.baseball06.dto.ApiResponse;
import java.sql.SQLException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CustomAdvice {

  @ExceptionHandler(Exception.class)
  @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
  public ApiResponse handleException(Exception e) {
    return ApiResponse.error(e.getMessage());
  }

  @ExceptionHandler(SQLException.class)
  @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
  public ApiResponse handleSQLException(SQLException e) {
    return ApiResponse.error(e.getMessage());
  }
}
