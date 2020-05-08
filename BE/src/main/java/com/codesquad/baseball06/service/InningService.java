package com.codesquad.baseball06.service;


import com.codesquad.baseball06.model.entity.Batter;
import com.codesquad.baseball06.model.entity.HalfInning;
import com.codesquad.baseball06.model.entity.Pitcher;
import com.codesquad.baseball06.model.type.BattingResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class InningService {

  private static final Logger log = LoggerFactory.getLogger(InningService.class);

  private final PlateAppearanceService plateAppearanceService;

  public InningService(PlateAppearanceService plateAppearanceService) {
    this.plateAppearanceService = plateAppearanceService;
  }

  public BattingResult doWork(HalfInning halfInning, Pitcher pitcher, Batter batter) {
    BattingResult plateAppearanceResult = plateAppearanceService.batting(halfInning, pitcher, batter);

    if (halfInning.isFinished()) {
      return BattingResult.END;
    }

    return plateAppearanceResult;
  }
}
