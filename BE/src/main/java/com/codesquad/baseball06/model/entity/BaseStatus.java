package com.codesquad.baseball06.model.entity;

public class BaseStatus {

  private final Long id;
  private final Long inningId;
  private Player firstBase;
  private Player secondBase;
  private Player thirdBase;

  public BaseStatus(Long id, Long inningId, Player firstBase, Player secondBase,
      Player thirdBase) {
    this.id = id;
    this.inningId = inningId;
    this.firstBase = firstBase;
    this.secondBase = secondBase;
    this.thirdBase = thirdBase;
  }

  public static BaseStatus create(Long id, Long inningId, Player firstBase, Player secondBase,
      Player thirdBase) {
    return new BaseStatus(id, inningId, firstBase, secondBase, thirdBase);
  }

  public Long getId() {
    return id;
  }

  public Long getInningId() {
    return inningId;
  }

  public Player getFirstBase() {
    return firstBase;
  }

  public Player getSecondBase() {
    return secondBase;
  }

  public Player getThirdBase() {
    return thirdBase;
  }
}
