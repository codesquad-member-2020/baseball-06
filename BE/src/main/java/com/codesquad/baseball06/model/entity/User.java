package com.codesquad.baseball06.model.entity;

import java.io.Serializable;

public class User implements Serializable {

  private String email;

  public User(String email) {
    this.email = email;
  }

  public static User create(String email) {
    return new User(email);
  }

  public String getEmail() {
    return email;
  }

  @Override
  public String toString() {
    return "User{" +
        "email='" + email + '\'' +
        '}';
  }
}
