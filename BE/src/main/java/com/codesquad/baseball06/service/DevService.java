package com.codesquad.baseball06.service;

import com.codesquad.baseball06.model.Batter;
import com.codesquad.baseball06.model.Pitcher;
import com.codesquad.baseball06.model.Team;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.LongStream;
import org.springframework.stereotype.Service;

@Service
public class DevService {

  public Team teamInitHelper(String teamName) {
    return Team.create(1L, teamName, createPitchers(teamName), createBatters(teamName));
  }

  public List<Pitcher> createPitchers(String teamName) {
    return Arrays.asList(Pitcher.create(1L, 2L, teamName + "투수 "));
  }

  public List<Batter> createBatters(String teamName) {
    return LongStream.range(2, 5)
        .mapToObj(l -> Batter.create(l, 1L, teamName + "타자" + l, 0.122))
        .collect(Collectors.toList());
  }
}
