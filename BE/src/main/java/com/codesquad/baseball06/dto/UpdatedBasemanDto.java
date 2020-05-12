package com.codesquad.baseball06.dto;

public class UpdatedBasemanDto {

  private SpecificBasemanDto firstBase;
  private SpecificBasemanDto secondBase;
  private SpecificBasemanDto thirdBase;

  private UpdatedBasemanDto(
      SpecificBasemanDto firstBase,
      SpecificBasemanDto secondBase,
      SpecificBasemanDto thirdBase) {
    this.firstBase = firstBase;
    this.secondBase = secondBase;
    this.thirdBase = thirdBase;
  }

  public SpecificBasemanDto getFirstBase() {
    return firstBase;
  }

  public SpecificBasemanDto getSecondBase() {
    return secondBase;
  }

  public SpecificBasemanDto getThirdBase() {
    return thirdBase;
  }

  public static UpdatedBasemanDto create(SpecificBasemanDto firstBase,
      SpecificBasemanDto secondBase, SpecificBasemanDto thirdBase) {
    return new UpdatedBasemanDto(firstBase, secondBase, thirdBase);
  }

  public static class SpecificBasemanDto {

    private String name;
    private Long id;

    private SpecificBasemanDto(String name, Long id) {
      this.name = name;
      this.id = id;
    }

    public static SpecificBasemanDto create(String name, Long id) {
      return new SpecificBasemanDto(name, id);
    }

    public String getName() {
      return name;
    }

    public Long getId() {
      return id;
    }
  }
}
