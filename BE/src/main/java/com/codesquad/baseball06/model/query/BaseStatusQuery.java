package com.codesquad.baseball06.model.query;

public class BaseStatusQuery {

  public static final String INCREASE_STRIKE_COUNT =
      "UPDATE inning_status SET strike_count = strike_count + 1 "
          + "WHERE half_inning_id = :half_inning_id;";
  public static final String INCREASE_BALL_COUNT =
      "UPDATE inning_status SET ball_count = ball_count + 1 "
          + "WHERE half_inning_id = :half_inning_id;";
  public static final String INITIALIZE_ALL_COUNT =
      "UPDATE inning_status SET strike_count = 0, ball_count = 0, out_count = 0 "
          + "WHERE half_inning_id = :half_inning_id;";
  public static final String INCREASE_OUT_COUNT_AND_INITIALIZE_OTHERS =
      "UPDATE inning_status "
          + "SET strike_count = 0, "
          + "ball_count = 0, "
          + "out_count = out_count + 1 "
          + "WHERE half_inning_id = :half_inning_id;";
  public static final String CREATE_NEW_INNING_STATUS =
      "INSERT INTO inning_status (strike_count, ball_count, out_count, half_inning_id)"
          + "VALUES (0, 0, 0, :half_inning_id);";
  public static final String UPDATE_BASE_STATUS =
      "UPDATE base_status\n"
          + "SET third_base = :third_base, "
          + "second_base = :second_base, "
          + "first_base = :first_base "
          + "WHERE half_inning_id = :half_inning_id;";
  public static final String CREATE_NEW_BASE_STATUS =
      "INSERT INTO base_status (half_inning_id) "
          + "VALUES (:half_inning_id);";
  public static final String GET_BASE_STATUS =
      "SELECT b.id, b.first_base, b.second_base, b.third_base, b.half_inning_id "
          + "FROM base_status b "
          + "WHERE b.half_inning_id = :half_inning_id;";
}
