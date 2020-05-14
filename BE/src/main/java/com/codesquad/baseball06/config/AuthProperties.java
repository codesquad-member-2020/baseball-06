package com.codesquad.baseball06.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class AuthProperties {

  @Value("${auth.client-id}")
  private String clientId;
  @Value("${auth.client-secret}")
  private String clientSecret;

  public String getClientId() {
    return clientId;
  }

  public String getClientSecret() {
    return clientSecret;
  }
}
