package com.codesquad.baseball06.model.query;

public class Game {

  public static final String FIND_BY_ID = "SELECT g.id, g.away_id, g.home_id, g.away_user, g.home_user, g.end, g.created_at FROM game g WHERE g.id = :id";
  public static final String INSERT = "INSERT INTO game (away_id, home_id) VALUES (:away_id, :home_id)";
  public static final String UPDATE_AWAY_USER = "UPDATE game g SET g.away_user = :AWAY WHERE g.id = :id";
  public static final String UPDATE_HOME_USER = "UPDATE game g SET g.home_user = :HOME WHERE g.id = :id";
}
