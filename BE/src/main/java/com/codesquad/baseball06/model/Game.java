package com.codesquad.baseball06.model;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

public class Game {

  private final Long id;
  private final List<Integer> teams;
  private final List<User> users;
  private final Boolean end;
  private final LocalDateTime createdAt;

  public Game(Long id, List<Integer> teams, List<User> users, Boolean end,
      LocalDateTime createdAt) {
    this.id = id;
    this.teams = teams;
    this.users = users;
    this.end = end;
    this.createdAt = createdAt;
  }

  public static Game create(Long id, Integer away, Integer home, String awayUser, String homeUser,
      Boolean end, Timestamp createdAt) {
    return new Game(id
        , Arrays.asList(away, home)
        , Arrays.asList(User.create(awayUser), User.create(homeUser))
        , end, createdAt.toLocalDateTime());
  }
}
