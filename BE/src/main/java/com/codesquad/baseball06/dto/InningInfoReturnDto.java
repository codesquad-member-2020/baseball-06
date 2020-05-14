package com.codesquad.baseball06.dto;

import com.codesquad.baseball06.model.entity.BaseStatus;
import com.codesquad.baseball06.model.entity.HalfInning;
import com.codesquad.baseball06.model.entity.InningStatus;
import java.util.List;


public class InningInfoReturnDto {

  private List<HalfInning> earlyInningList;
  private List<HalfInning> lateInningList;
  private InningStatus inningStatus;
  private BaseStatus baseStatus;

  private InningInfoReturnDto(
      List<HalfInning> earlyInningList,
      List<HalfInning> lateInningList,
      InningStatus inningStatus,
      BaseStatus baseStatus) {
    this.earlyInningList = earlyInningList;
    this.lateInningList = lateInningList;
    this.inningStatus = inningStatus;
    this.baseStatus = baseStatus;
  }

  public static InningInfoReturnDto create(List<HalfInning> earlyInningList,
      List<HalfInning> lateInningList,
      InningStatus inningStatus,
      BaseStatus baseStatus) {
    return new InningInfoReturnDto(earlyInningList, lateInningList, inningStatus, baseStatus);
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

  public BaseStatus getBaseStatus() {
    return baseStatus;
  }
}
