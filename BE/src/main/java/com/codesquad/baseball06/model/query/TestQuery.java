package com.codesquad.baseball06.model.query;

public class TestQuery {

  public static String INNINGSTATUS_SQL_TEST =
      "INSERT INTO inning_status (strike_count, ball_count, out_count, half_inning_id) " +
          "VALUES (:strike_count, :ball_count, :out_count, :half_inning_id)";
  public static String BASEMAN_SQL_TEST =
      "INSERT INTO base_status (first_base, second_base, third_base, half_inning_id) " +
          "VALUES (:first_base, :second_base, :third_base, :half_inning_id)";
  public static String SCORE_SQL_TEST =
      "INSERT INTO half_inning (game_id, inning_index, type, score, end) " +
          "VALUES (:game_id, :inning_index, :type, :score, :end)";
  public static String GAME_SQL_TEST =
      "INSERT INTO game (home_id, away_id, home_user, away_user, end)" +
          "VALUES (:home_id, :away_id, :home_user, :away_user, :end)";
  public static String PLATE_SQL_TEST =
      "INSERT INTO plate_appearance (half_inning_id, pitcher, batter, batter_index, result, end)"
          + " VALUES (:half_inning_id, :pitcher, :batter, :batter_index, :result, :end)";
}
