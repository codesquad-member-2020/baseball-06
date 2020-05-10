package com.codesquad.baseball06.model.entity;

import com.codesquad.baseball06.model.type.InningType;
import com.codesquad.baseball06.model.type.TeamType;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Game {

  private final Long id;
  private final List<Team> teams;
  private final List<User> users;
  private final LocalDateTime createdAt;
  private Boolean end;
  private List<HalfInning> earlyInningList;
  private List<HalfInning> lateInningList;

  public Game(Long id, List<Team> teams, List<User> users, Boolean end, LocalDateTime createdAt,
      List<HalfInning> earlyInningList, List<HalfInning> lateInningList) {
    this.id = id;
    this.teams = teams;
    this.users = users;
    this.end = end;
    this.createdAt = createdAt;
    this.earlyInningList = earlyInningList;
    this.lateInningList = lateInningList;
  }

  public static Game create(Long id, Team away, Team home, String awayUser, String homeUser,
      Boolean end, Timestamp createdAt) {
    return new Game(id
        , Arrays.asList(away, home)
        , Arrays.asList(User.create(awayUser), User.create(homeUser))
        , end, createdAt.toLocalDateTime()
        // 이후 HalfInningDao.findHalfInningByGameId() 를 이용해 가져옵니다
        , new ArrayList<>()
        , new ArrayList<>());
  }

  public boolean isStartPossible() {
    return isUserJoined(TeamType.AWAY) && isUserJoined(TeamType.HOME);
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

  private boolean isUserJoined(TeamType teamType) {
    return Objects.nonNull(users.get(teamType.getCode()).getEmail());
  }

  public int addHalfInning() {
    if (earlyInningList.size() == lateInningList.size()) {
      earlyInningList.add(
          HalfInning.create(id, earlyInningList.size() + 1, InningType.EARLY));

      return earlyInningList.size();
    }

    lateInningList.add(
        HalfInning.create(id, lateInningList.size() + 1, InningType.LATE));

    return lateInningList.size();
  }
}
