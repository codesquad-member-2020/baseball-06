package com.codesquad.baseball06.model.query;

public class InningStatusQuery {

  public static final String FIND_BY_ID = "SELECT i.id, i.half_inning_id, i.strike_count, i.ball_count, i.out_count FROM inning_status i WHERE i.id = :id";
  public static final String FIND_BY_GAME_ID =
      "SELECT iss.id, iss.half_inning_id, iss.strike_count, iss.ball_count, iss.out_count "
          + "FROM inning_status iss, half_inning hi "
          + "WHERE hi.game_id = :game_id "
          + "AND iss.half_inning_id = hi.id "
          + "AND hi.end = 0";
  public static final String FIND_BY_INNING_ID =
      "SELECT i.id, i.half_inning_id, i.strike_count, i.ball_count, i.out_count "
          + "FROM inning_status i "
          + "WHERE i.half_inning_id = :half_inning_id";
  public static final String INSERT = "INSERT INTO inning_status (half_inning_id) VALUES (:half_inning_id)";
  public static final String UPDATE = "UPDATE inning_status "
      + "SET strike_count = :strike_count, "
      + "ball_count = :ball_count, "
      + "out_count = :out_count "
      + "WHERE half_inning_id = :half_inning_id";

  public static final String INNING_STATUS =
      "SELECT i.id, i.strike_count, i.ball_count, i.out_count, i.half_inning_id FROM inning_status i";

  public static final String BASEMAN_SQL =
      "SELECT p.id, p.team_id, p.type, p.name, p.batting_average,\n"
          + "(\n"
          + "\tCASE\n"
          + "    WHEN p.id = b.first_base THEN '1'\n"
          + "    WHEN p.id = b.second_base THEN '2'\n"
          + "    WHEN p.id = b.third_base THEN '3'\n"
          + "    END\n"
          + ") AS base_status\n"
          + "FROM player p, base_status b\n"
          + "\n"
          + "WHERE p.id = b.first_base\n"
          + "OR p.id = b.second_base\n"
          + "OR p.id = b.third_base;";
  public static String GET_TEAM_SCORES =
      "SELECT i.id, i.score, IF(i.type, '홈', '어웨이') as type FROM half_inning i\n"
          + "WHERE i.game_id = :game_id \n"
          + "GROUP BY i.score, i.type, i.id;";

  public static String GET_INNING_INDEX_AND_TYPE =
      "SELECT inning_index, type FROM half_inning\n"
          + "WHERE game_id = :game_id \n"
          + "ORDER BY id DESC LIMIT 1;";
}
