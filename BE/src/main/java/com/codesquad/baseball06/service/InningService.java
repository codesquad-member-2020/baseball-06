package com.codesquad.baseball06.service;


import com.codesquad.baseball06.model.Batter;
import com.codesquad.baseball06.model.Inning;
import com.codesquad.baseball06.model.Pitcher;
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

  public BattingResult doWork(Inning inning, Pitcher pitcher, Batter batter) {
    log.debug("### pitcher : {}", pitcher.getName());
    log.debug("### batter : {}", batter.getName());
    BattingResult plateAppearanceResult = plateAppearanceService.batting(inning, pitcher, batter);

    if (isInningChange(inning)) {
      log.debug("### change!!!!!!!!!!!!");
      return BattingResult.END;
    }

    return plateAppearanceResult;
  }

  private boolean isInningChange(Inning inning) {
    return inning.getOut().equals(3);
  }
}
