package com.codesquad.baseball06.model;

public class ApiResponse<T> {

  private final T body;

  private ApiResponse(T body) {
    this.body = body;
  }

  public static <T> ApiResponse ok(T body) {
    return new ApiResponse(body);
  }

  public static <T> ApiResponse error(T body) {
    return new ApiResponse(body);
  }

  public T getBody() {
    return body;
  }
}
