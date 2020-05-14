import React, { useContext } from "react";
import styled from "styled-components";
import { BaseballContext } from "../../store/Store";

function Score() {
  const { score } = useContext(BaseballContext);

  return (
    <ScoreArea>
      <TeamNameArea>
        <Team>ddxx</Team>
        <Player visibility={"hidden"}>Player</Player>
      </TeamNameArea>
      <Team score>{score.Away}</Team>
      <Vs>VS</Vs>
      <Team score>{score.Home}</Team>
      <TeamNameArea>
        <Team>ddddd</Team>
        <Player>Player</Player>
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

const Player = styled.span`
  color: ${(props) => props.theme.highlightColor};
  visibility: ${(props) => {
    if (props.visibility === "hidden") return "hidden";
  }};
`;

export default Score;
