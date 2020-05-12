package com.codesquad.baseball06.model.query;

public class UpdateInningStatusQuery {

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
      "UPDATE inning_status \n"
          + "SET strike_count = 0,\n"
          + "ball_count = 0,\n"
          + "out_count = out_count + 1\n"
          + "WHERE half_inning_id = :half_inning_id;";
  public static final String CREATE_NEW_INNING_STATUS =
      "INSERT INTO inning_status (strike_count, ball_count, out_count, half_inning_id)"
          + "VALUES (0, 0, 0, :half_inning_id);";
  public static final String UPDATE_INNING_PLAYER =
      "UPDATE base_status\n"
          + "SET third_base = :third_base,\n"
          + "second_base = :second_base,\n"
          + "first_base = :first_base\n"
          + "WHERE half_inning_id = :half_inning_id;";
  public static final String CREATE_NEW_BASE_STATUS =
      "INSERT INTO base_status (half_inning_id) "
          + "VALUES (:half_inning_id);";
}
