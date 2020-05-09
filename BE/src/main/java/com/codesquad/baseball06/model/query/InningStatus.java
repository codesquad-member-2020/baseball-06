package com.codesquad.baseball06.model.query;

public class InningStatus {

  public static final String INNING_STATUS =
      "SELECT i.id, i.strike_count, i.ball_count, i.out_count, i.half_inning_id FROM inning_status i";

  public static final String BASEMAN_SQL = "SELECT p.id, p.team_id, p.type, p.name, p.batting_average,\n"
      + "(\n"
      + "\tCASE\n"
      + "    WHEN p.id = b.first_base THEN '1'\n"
      + "    WHEN p.id = b.second_base THEN '2'\n"
      + "    WHEN p.id = b.third_base THEN '3'\n"
      + "    END\n"
      + ") AS base_status\n"
      + "FROM player p, base_status b\n"
      + "\n"
      + "WHERE p.id = b.first_base\n"
      + "OR p.id = b.second_base\n"
      + "OR p.id = b.third_base;";
}
