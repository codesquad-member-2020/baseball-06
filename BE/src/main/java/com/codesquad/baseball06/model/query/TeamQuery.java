package com.codesquad.baseball06.model.query;

public class TeamQuery {

  public static final String FIND_BY_ID = "SELECT t.id, t.name FROM team t WHERE t.id = :id";
  public static final String FIND_AWAY_TEAM_BY_GAME_ID = "SELECT t.id, t.name "
      + "FROM team t, game g "
      + "WHERE t.id = g.away_id "
      + "AND g.id = :game_id;";
  public static final String FIND_HOME_TEAM_BY_GAME_ID = "SELECT t.id, t.name "
      + "FROM team t, game g "
      + "WHERE t.id = g.home_id "
      + "AND g.id = :game_id;";
}
