package com.codesquad.baseball06.dto;

import com.codesquad.baseball06.model.entity.HalfInning;
import com.codesquad.baseball06.model.entity.InningStatus;
import java.util.List;


public class InningInfoReturnDto {

  private List<HalfInning> earlyInningList;
  private List<HalfInning> lateInningList;
  private InningStatus inningStatus;

  private InningInfoReturnDto(
      List<HalfInning> earlyInningList,
      List<HalfInning> lateInningList,
      InningStatus inningStatus) {
    this.earlyInningList = earlyInningList;
    this.lateInningList = lateInningList;
    this.inningStatus = inningStatus;
  }

  public static InningInfoReturnDto create(List<HalfInning> earlyInningList,
      List<HalfInning> lateInningList,
      InningStatus inningStatus) {
    return new InningInfoReturnDto(earlyInningList, lateInningList, inningStatus);
  }

  public List<HalfInning> getEarlyInningList() {
    return earlyInningList;
  }

  public List<HalfInning> getLateInningList() {
    return lateInningList;
  }

  public InningStatus getInningStatus() {
    return inningStatus;
  }
}
