package com.codesquad.baseball06.model.query;

public class InningStatus {

  public static final String FIND_BY_ID = "SELECT i.id, i.half_inning_id, i.strike_count, i.ball_count, i.out_count FROM inning_status i WHERE i.id = :id";
  public static final String INSERT = "INSERT INTO inning_status (half_inning_id) VALUES (:half_inning_id)";
}
