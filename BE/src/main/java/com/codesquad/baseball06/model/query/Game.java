package com.codesquad.baseball06.model.query;

public class Game {

  public static final String FIND_BY_ID = "SELECT g.id, g.name FROM game g WHERE g.id = :id";
  public static final String INSERT = "INSERT INTO game (away_id, home_id) VALUES (:away_id, :home_id)";
}
