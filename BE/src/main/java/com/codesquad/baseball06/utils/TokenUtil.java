package com.codesquad.baseball06.utils;


import com.codesquad.baseball06.config.JwtProperties;
import com.codesquad.baseball06.controller.AuthController;
import com.codesquad.baseball06.message.AuthMessages;
import com.codesquad.baseball06.message.ErrorMessages;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.Map;
import javax.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class TokenUtil {

  private static final Logger log = LoggerFactory.getLogger(AuthController.class);
  private static JwtProperties staticJwtProperties;
  private final JwtProperties jwtProperties;

  public TokenUtil(JwtProperties jwtProperties) {
    this.jwtProperties = jwtProperties;
  }

  public static String create(Map<String, String> claims) {
    try {
      JwtBuilder jwt = Jwts.builder()
          .setHeaderParam("typ", "JWT")
          .setIssuer("Dan")
          .setIssuedAt(new Date(System.currentTimeMillis()))
          .setExpiration(new Date(System.currentTimeMillis() + AuthMessages.EXPIRED_TIME));
      for (String key : claims.keySet()) {
        jwt.claim(key, claims.get(key));
      }

      return jwt.signWith(SignatureAlgorithm.HS256, generateKey()).compact();
    } catch (Exception e) {
      throw new RuntimeException(ErrorMessages.FAILED_MAKE_JWT);
    }
  }

  private static byte[] generateKey() {
    return staticJwtProperties.getSalt().getBytes(StandardCharsets.UTF_8);
  }

  @PostConstruct
  private void initStaticJwtProperties() {
    staticJwtProperties = this.jwtProperties;
  }
}
