package com.codesquad.baseball06.model.query;

public class Inning {

  public static String GET_TEAM_SCORES =
      "SELECT i.id, i.score, IF(i.type, '홈', '어웨이') as type FROM half_inning i\n"
          + "WHERE i.game_id = :game_id \n"
          + "GROUP BY i.score, i.type, i.id;";

  public static String GET_INNING_INDEX_AND_TYPE =
      "SELECT inning_index, type FROM half_inning\n"
          + "WHERE game_id = :game_id \n"
          + "ORDER BY id DESC LIMIT 1;";
}
