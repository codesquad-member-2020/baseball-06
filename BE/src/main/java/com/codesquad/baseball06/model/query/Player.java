package com.codesquad.baseball06.model.query;

public class Player {

  public static final String FIND_BY_ID_AND_TYPE =
      "SELECT p.id, p.team_id, p.type, p.name, p.batting_average "
          + "FROM player p "
          + "WHERE p.id = :id "
          + "  AND p.type = :type";
  public static final String FIND_BY_TYPE_AND_TEAM_ID =
      "SELECT p.id, p.team_id, p.type, p.name, p.batting_average "
          + "FROM player p "
          + "WHERE p.type = :type"
          + "  AND p.team_id = :team_id";
  public static final String FIND_BY_TYPE =
      "SELECT p.id, p.team_id, p.type, p.name, p.batting_average "
          + "FROM player p "
          + "WHERE p.type = :type";
}
