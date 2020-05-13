package com.codesquad.baseball06.model.query;

public class UpdatePlateAppearanceQuery {

  public static final String CREATE_NEW_PLATE_APPEARANCE =
      "INSERT INTO plate_appearance (half_inning_id, pitcher, batter, batter_index, result, end) "
          + "VALUES (:half_inning_id, :pitcher, :batter, :batter_index, :result, :end)";

  public static final String GET_LAST_BATTER_INDEX_BY_HALF_INNING_ID =
      "SELECT batter_index FROM plate_appearance\n"
          + "WHERE half_inning_id = 1\n"
          + "ORDER BY batter_index\n"
          + "DESC LIMIT 1;";

  public static final String GET_LAST_PLATE_APPEARANCE_BY_HALF_INNING_ID =
      "SELECT * FROM plate_appearance "
          + "WHERE half_inning_id = :half_inning_id"
          + "ORDER BY id "
          + "DESC LIMIT 1;";
}
