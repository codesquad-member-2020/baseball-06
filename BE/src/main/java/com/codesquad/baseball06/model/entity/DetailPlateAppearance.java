package com.codesquad.baseball06.model.entity;

import com.codesquad.baseball06.model.type.BattingResult;
import java.time.LocalDateTime;

public class DetailPlateAppearance {

  private final Long id;
  private final Long detailPlateAppearanceId;
  private final BattingResult result;
  private final LocalDateTime createdAt;

  private DetailPlateAppearance(Long id, Long detailPlateAppearanceId, BattingResult result,
      LocalDateTime createdAt) {
    this.id = id;
    this.detailPlateAppearanceId = detailPlateAppearanceId;
    this.result = result;
    this.createdAt = createdAt;
  }

  private DetailPlateAppearance(Long detailPlateAppearanceId, BattingResult result,
      LocalDateTime createdAt) {
    this.id = null;
    this.detailPlateAppearanceId = detailPlateAppearanceId;
    this.result = result;
    this.createdAt = createdAt;
  }

  public static DetailPlateAppearance create(Long id, Long detailPlateAppearanceId,
      BattingResult result, LocalDateTime createdAt) {
    return new DetailPlateAppearance(id, detailPlateAppearanceId, result, createdAt);
  }

  public static DetailPlateAppearance create(Long detailPlateAppearanceId, BattingResult result,
      LocalDateTime createdAt) {
    return new DetailPlateAppearance(detailPlateAppearanceId, result, createdAt);
  }

  public Long getId() {
    return id;
  }

  public Long getDetailPlateAppearanceId() {
    return detailPlateAppearanceId;
  }

  public BattingResult getResult() {
    return result;
  }

  public LocalDateTime getCreatedAt() {
    return createdAt;
  }
}
