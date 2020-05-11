package com.codesquad.baseball06.model.query;

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
          //TODO: 알 수 없는 이유로 아래를 넣어줘야 1개만 잡을 수 있다. 그런데 위의 쿼리도 잘 작동될 텐데 이상하다.
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
