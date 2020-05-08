package com.codesquad.baseball06.model.entity;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

public class Game {

  private final Long id;
  private final List<Team> teams;
  private final List<User> users;
  private final Boolean end;
  private final LocalDateTime createdAt;
  private List<HalfInning> halfInningList;

  public Game(Long id, List<Team> teams, List<User> users, Boolean end,
      LocalDateTime createdAt) {
    this.id = id;
    this.teams = teams;
    this.users = users;
    this.end = end;
    this.createdAt = createdAt;
  }

  public static Game create(Long id, Team away, Team home, String awayUser, String homeUser,
      Boolean end, Timestamp createdAt) {
    return new Game(id
        , Arrays.asList(away, home)
        , Arrays.asList(User.create(awayUser), User.create(homeUser))
        , end, createdAt.toLocalDateTime());
  }

  public Long getId() {
    return id;
  }

  public List<Team> getTeams() {
    return teams;
  }

  public List<User> getUsers() {
    return users;
  }

  public Boolean getEnd() {
    return end;
  }

  public LocalDateTime getCreatedAt() {
    return createdAt;
  }
}
