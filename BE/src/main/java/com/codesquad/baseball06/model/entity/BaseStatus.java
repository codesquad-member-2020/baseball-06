package com.codesquad.baseball06.model.entity;

public class BaseStatus {

  private final Long id;
  private final Long halfInningId;
  private Boolean firstBase;
  private Boolean secondBase;
  private Boolean thirdBase;

//  private Player firstBase;
//  private Player secondBase;
//  private Player thirdBase;

  private BaseStatus(Long id, Long halfInningId) {
    this.id = id;
    this.halfInningId = halfInningId;
    this.firstBase = false;
    this.secondBase = false;
    this.thirdBase = false;
  }

  public BaseStatus(Long id, Long halfInningId, Boolean firstBase, Boolean secondBase,
      Boolean thirdBase) {
    this.id = id;
    this.halfInningId = halfInningId;
    this.firstBase = firstBase;
    this.secondBase = secondBase;
    this.thirdBase = thirdBase;
  }

  public static BaseStatus create(Long id, Long inningId, Boolean firstBase, Boolean secondBase,
      Boolean thirdBase) {
    return new BaseStatus(id, inningId, firstBase, secondBase, thirdBase);
  }

  public static BaseStatus create(Long inningId) {
    return new BaseStatus(null, inningId);
  }

  public Long getId() {
    return id;
  }

  public Long getHalfInningId() {
    return halfInningId;
  }

  public Boolean getFirstBase() {
    return firstBase;
  }

  public Boolean getSecondBase() {
    return secondBase;
  }

  public Boolean getThirdBase() {
    return thirdBase;
  }

  public void updateBases() {
    if (getSecondBase().equals(true) && getThirdBase().equals(false)) {
      addThirdBase();
    }
    if (getFirstBase().equals(true) && getSecondBase().equals(false)) {
      addSecondBase();
    }
    if (getFirstBase().equals(false)) {
      addFirstBase();
    }
  }

  public void addFirstBase() {
    this.firstBase = true;
  }

  public void addSecondBase() {
    this.secondBase = true;
  }

  public void addThirdBase() {
    this.thirdBase = true;
  }
}
