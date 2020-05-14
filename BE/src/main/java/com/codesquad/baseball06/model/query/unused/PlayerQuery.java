package com.codesquad.baseball06.model.query.unused;

public class PlayerQuery {

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
  public static final String FIND_CURRENT_BATTER =
      "SELECT p.id, p.team_id, p.type, p.name, p.batting_average, pa.batter_index \n"
          + "FROM player p, plate_appearance pa\n"
          + "WHERE p.id = (SELECT p.batter FROM plate_appearance p, half_inning i\n"
          + "WHERE i.game_id = 1\n"
          + "ORDER BY i.id DESC LIMIT 1)\n"
          + "AND pa.batter = p.id\n"
          + "ORDER BY p.id DESC LIMIT 1;";
  public static final String FIND_CURRENT_PITCHER =
      "SELECT p.id, p.team_id, p.type, p.name FROM player p\n"
          + "WHERE p.id = (SELECT p.pitcher FROM plate_appearance p, half_inning i\n"
          + "WHERE i.game_id = 1\n"
          + "ORDER BY i.id DESC LIMIT 1);";
  public static final String FIND_CURRENT_PLAYER =
      "SELECT p.id, p.team_id, p.type, p.name, p.batting_average FROM player p\n"
          + "WHERE p.id = (SELECT p.pitcher FROM plate_appearance p, half_inning i\n"
          + "WHERE i.game_id = :game_id\n"
          + "ORDER BY i.id DESC LIMIT 1)\n"
          + "OR p.id = (SELECT p.batter FROM plate_appearance p, half_inning i\n"
          + "WHERE i.game_id = :game_id\n"
          + "ORDER BY i.id DESC LIMIT 1);";
}
