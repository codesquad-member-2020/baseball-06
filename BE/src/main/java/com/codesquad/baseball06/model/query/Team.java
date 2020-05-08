package com.codesquad.baseball06.model.query;

public class Team {

  public static final String FIND_BY_ID = "SELECT t.id, t.name FROM team t WHERE t.id = :id";
}
