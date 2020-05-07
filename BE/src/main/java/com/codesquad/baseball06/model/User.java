package com.codesquad.baseball06.model;

public class User {

  private final String email;

  public User(String email) {
    this.email = email;
  }

  public static User create(String email) {
    return new User(email);
  }

  public String getEmail() {
    return email;
  }
}
