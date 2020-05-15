package com.codesquad.baseball06.model.query;

public class HalfInningQuery {

  public static final String FIND_BY_ID = "SELECT h.id, h.game_id, h.inning_index, h.type, h.score, h.end, h.created_at FROM half_inning h WHERE h.id = :id";
  public static final String FIND_BY_GAME_ID = "SELECT h.id, h.game_id, h.inning_index, h.type, h.score, h.end, h.created_at FROM half_inning h WHERE h.game_id = :game_id";
  public static final String INSERT = "INSERT INTO half_inning (game_id, inning_index, type) VALUES (:game_id, :inning_index, :type)";
  public static final String UPDATE_HALF_INNING = "UPDATE half_inning SET score = :score, end = :end WHERE id = :half_inning_id";
}
