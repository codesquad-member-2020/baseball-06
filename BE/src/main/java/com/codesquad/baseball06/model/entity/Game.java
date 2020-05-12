package com.codesquad.baseball06.model.entity;

import com.codesquad.baseball06.model.type.InningType;
import com.codesquad.baseball06.model.type.TeamType;
import com.google.common.collect.Iterables;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Game {

  private final Long id;
  private final List<Team> teams;
  private final Map<TeamType, User> users;
  private final LocalDateTime createdAt;
  private Boolean end;
  private List<HalfInning> earlyInningList;
  private List<HalfInning> lateInningList;

  public Game(Long id, List<Team> teams, Map<TeamType, User> users, Boolean end,
      LocalDateTime createdAt,
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
    Map<TeamType, User> users = new HashMap<>();
    users.put(TeamType.AWAY, User.create(awayUser));
    users.put(TeamType.HOME, User.create(homeUser));

    return new Game(id
        , Arrays.asList(away, home)
        , users
        , end, createdAt.toLocalDateTime()
        // 이후 HalfInningDao.findHalfInningByGameId() 를 이용해 가져옵니다
        , new ArrayList<>()
        , new ArrayList<>());
  }

  private boolean isUserJoined(TeamType teamType) {
    return Objects.nonNull(users.get(teamType).getEmail());
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

  public Map<TeamType, User> getUsers() {
    return users;
  }

  public Boolean getEnd() {
    return end;
  }

  public LocalDateTime getCreatedAt() {
    return createdAt;
  }

  public List<HalfInning> getEarlyInningList() {
    return earlyInningList;
  }

  public List<HalfInning> getLateInningList() {
    return lateInningList;
  }

  public User updateUser(TeamType teamType, User user) {
    users.put(teamType, user);
    return users.get(teamType);
  }

  public boolean isNewGame() {
    if (earlyInningList.size() == 0 && lateInningList.size() == 0) {
      return true;
    }
    return false;
  }

  public HalfInning getRunningHalfInning() {
    HalfInning earlyInningLast = Iterables.getLast(earlyInningList);
    HalfInning lateInningLast = Iterables.getLast(lateInningList);

    if (earlyInningLast.getEnd() && lateInningLast.getEnd()) {
      return addHalfInning();
    } else {
      if (earlyInningLast.getEnd()) {
        return Iterables.getLast(lateInningList);
      }
      return Iterables.getLast(earlyInningList);
    }
  }

  public HalfInning addHalfInning() {
    if (earlyInningList.size() == lateInningList.size()) {
      earlyInningList.add(
          HalfInning.create(id, earlyInningList.size() + 1, InningType.EARLY));

      return earlyInningList.get(earlyInningList.size() - 1);
    }

    lateInningList.add(
        HalfInning.create(id, lateInningList.size() + 1, InningType.LATE));

    return lateInningList.get(lateInningList.size() - 1);
  }

  @Override
  public String toString() {
    return "GameQuery{" +
        "id=" + id +
        ", teams=" + teams +
        ", users=" + users +
        ", createdAt=" + createdAt +
        ", end=" + end +
        ", earlyInningList=" + earlyInningList +
        ", lateInningList=" + lateInningList +
        '}';
  }

  public boolean isEndGame() {
    return (earlyInningList.size() == 9 && lateInningList.size() == 9
        && Iterables.getLast(earlyInningList).getEnd()
        && Iterables.getLast(lateInningList).getEnd());
  }

  public void setEarlyInningList(
      List<HalfInning> earlyInningList) {
    this.earlyInningList = earlyInningList;
  }

  public void setLateInningList(
      List<HalfInning> lateInningList) {
    this.lateInningList = lateInningList;
  }
}
