package com.codesquad.baseball06.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class JwtProperties {

  @Value("${jwt.salt}")
  private String salt;

  public String getSalt() {
    return salt;
  }
}
