import React, { useState, useRef, useContext } from "react";
import styled from "styled-components";
import { GAME_START_URL } from "../../constants/url";

function GameSelection({ teams, history }) {
  const offenseTeamName = teams.team1.name;
  const defenseTeamName = teams.team2.name;
  const payload = {
    defenseTeamName,
    offenseTeamName,
  };

  const onClickHomeTeam = (e) => {
    let teamType = "defense";
    let teamInfo = { teamType, payload };

    fetch(GAME_START_URL)
      .then((res) => moveGameProgression(`/${teamType}`, teamInfo))
      .then((data) => console.log(data));
  };

  const onClickAwayTeam = (e) => {
    let teamType = "offense";
    let teamInfo = { teamType, payload };

    fetch(GAME_START_URL)
      .then((res) => moveGameProgression(`/${teamType}`, teamInfo))
      .then((data) => console.log(data));
  };

  const moveGameProgression = (path, teamInfo) => {
    const pathname = path;
    history.push({
      pathname,
      teamInfo,
    });
  };

  return (
    <GameSelectionArea>
      <GameNumber>GAME {teams.id}</GameNumber>
      <Teams>
        <Team onClick={onClickAwayTeam}>{offenseTeamName}</Team>
        <Vs>vs</Vs>
        <Team onClick={onClickHomeTeam}>{defenseTeamName}</Team>
      </Teams>
    </GameSelectionArea>
  );
}

const GameSelectionArea = styled.div`
  width: 500px;
  height: 100px;
  margin: 20px 0;
  background-color: #b4b4b4;
  opacity: 0.8;
  border-radius: 15px;
`;

export const Vs = styled.span`
  font-size: 30px;
  color: #555;
`;

const GameNumber = styled.div`
  padding: 10px 0;
  color: ${(props) => props.theme.highlightColor};
  font-size: 18px;
`;

const Teams = styled.div`
  display: flex;
  justify-content: space-around;
`;

const Team = styled.span`
  font-size: 30px;
  cursor: pointer;
  &:hover {
    color: ${(props) => props.theme.highlightColor};
  }
`;

export default GameSelection;
