import React, { useContext, useEffect, useState } from "react";
import styled from "styled-components";
import { OFFENSE } from "../GameProgression/Offense";
import { BaseballContext } from "../../store/Store";
import { gameSelectionMock } from "../../mock/gameSelectionMock";

function Score({ team }) {
  const { score, selectedTeamInfo, teamName } = useContext(BaseballContext);
  const { offenseTeamName, defenseTeamName } = selectedTeamInfo;
  console.log(selectedTeamInfo, 12);

  const showPlayer = () => {
    if (team === OFFENSE) return `&.home-player {visibility:hidden}`;
    else return `&.away-player {visibility:hidden}`;
  };

  const Player = styled.span`
    color: ${(props) => props.theme.highlightColor};
    ${showPlayer()}
  `;

  return (
    <ScoreArea>
      <TeamNameArea>
        <Team>{offenseTeamName}</Team>
        <Player className={"away-player"}>Player</Player>
      </TeamNameArea>
      <Team score>{score.Away}</Team>
      <Vs>VS</Vs>
      <Team score>{score.Home}</Team>
      <TeamNameArea>
        <Team>{defenseTeamName}</Team>
        <Player className={"home-player"}>Player</Player>
      </TeamNameArea>
    </ScoreArea>
  );
}

const TeamNameArea = styled.div`
  display: flex;
  flex-direction: column;
  padding: 18px;
`;

const Team = styled.span`
  margin: 0 20px 10px;
  font-size: 40px;
  color: ${(props) =>
    props.score ? props.theme.highlightColor : props.theme.mainFontColor};
`;

const Vs = styled.span`
  margin: 0 20px;
  color: ${(props) => props.theme.gray};
  font-size: 30px;
`;

const ScoreArea = styled.div`
  display: flex;
  justify-content: center;
  align-items: center;
  padding: 18px 0;
`;

export default Score;
