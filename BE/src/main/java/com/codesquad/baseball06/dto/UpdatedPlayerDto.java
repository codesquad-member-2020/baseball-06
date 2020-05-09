package com.codesquad.baseball06.dto;

import com.codesquad.baseball06.model.type.PlayerType;

public class UpdatedPlayerDto {
  private Long id;
  private String name;
  private PlayerType type;
  private String teamName;

  public UpdatedPlayerDto(Long id, String name, PlayerType type, String teamName) {
    this.id = id;
    this.name = name;
    this.type = type;
    this.teamName = teamName;
  }
}
