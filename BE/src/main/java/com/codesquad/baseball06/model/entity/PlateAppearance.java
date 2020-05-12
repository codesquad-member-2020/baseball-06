package com.codesquad.baseball06.model.entity;

import com.codesquad.baseball06.model.type.BattingResult;
import java.time.LocalDateTime;

public class PlateAppearance {

  private final Long id;
  private final Long halfInningId;
  private final Pitcher pitcher;
  private final Batter batter;
  private final Integer batterIndex;
  private final BattingResult result;
  private final LocalDateTime createdAt;
  private Boolean end;


  public PlateAppearance(Long id, Long halfInningId, Pitcher pitcher, Batter batter,
      Integer batterIndex, BattingResult result, Boolean end, LocalDateTime createdAt) {
    this.id = id;
    this.halfInningId = halfInningId;
    this.pitcher = pitcher;
    this.batter = batter;
    this.batterIndex = batterIndex;
    this.result = result;
    this.end = end;
    this.createdAt = createdAt;
  }

  public PlateAppearance(Long halfInningId, Pitcher pitcher, Batter batter,
      Integer batterIndex, BattingResult result, Boolean end, LocalDateTime createdAt) {
    this.id = null;
    this.halfInningId = halfInningId;
    this.pitcher = pitcher;
    this.batter = batter;
    this.batterIndex = batterIndex;
    this.result = result;
    this.end = end;
    this.createdAt = createdAt;
  }

  public static PlateAppearance create(Long id, Long halfInningId, Pitcher pitcher, Batter batter,
      Integer batterIndex, BattingResult result, Boolean end, LocalDateTime createdAt) {
    return new PlateAppearance(id, halfInningId, pitcher, batter, batterIndex, result, end,
        createdAt);
  }

  public static PlateAppearance create(Long halfInningId, Pitcher pitcher, Batter batter,
      Integer batterIndex, BattingResult result, Boolean end, LocalDateTime createdAt) {
    return new PlateAppearance(halfInningId, pitcher, batter, batterIndex, result, end,
        createdAt);
  }

  public Long getId() {
    return id;
  }

  public Long getHalfInningId() {
    return halfInningId;
  }

  public Pitcher getPitcher() {
    return pitcher;
  }

  public Batter getBatter() {
    return batter;
  }

  public Integer getBatterIndex() {
    return batterIndex;
  }

  public BattingResult getResult() {
    return result;
  }

  public LocalDateTime getCreatedAt() {
    return createdAt;
  }

  public Boolean getEnd() {
    return end;
  }
}
