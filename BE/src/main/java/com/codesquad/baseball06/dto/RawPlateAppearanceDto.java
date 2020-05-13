package com.codesquad.baseball06.dto;

import java.sql.Timestamp;

public class RawPlateAppearanceDto {

  private Long id;
  private Long half_inning_id;
  private Long pitcher_id;
  private Long batter_id;
  private Integer batter_index;
  private Integer result_code;
  private Timestamp created_at;
  private Boolean end;

  public RawPlateAppearanceDto(Long id, Long half_inning_id, Long pitcher_id, Long batter_id,
      Integer batter_index, Integer result_code, Timestamp created_at, Boolean end) {
    this.id = id;
    this.half_inning_id = half_inning_id;
    this.pitcher_id = pitcher_id;
    this.batter_id = batter_id;
    this.batter_index = batter_index;
    this.result_code = result_code;
    this.created_at = created_at;
    this.end = end;
  }

  public static RawPlateAppearanceDto create(Long id, Long half_inning_id, Long pitcher_id,
      Long batter_id,
      Integer batter_index, Integer result_code, Timestamp created_at, Boolean end) {
    return new RawPlateAppearanceDto(id, half_inning_id, pitcher_id, batter_id, batter_index,
        result_code, created_at, end);
  }

  public Long getId() {
    return id;
  }

  public Long getHalf_inning_id() {
    return half_inning_id;
  }

  public Long getPitcher_id() {
    return pitcher_id;
  }

  public Long getBatter_id() {
    return batter_id;
  }

  public Integer getBatter_index() {
    return batter_index;
  }

  public Integer getResult_code() {
    return result_code;
  }

  public Timestamp getCreated_at() {
    return created_at;
  }

  public Boolean getEnd() {
    return end;
  }
}
