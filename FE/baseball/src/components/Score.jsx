import React from "react";
import styled, { ThemeProvider } from "styled-components";
import theme from "../styles/theme";
import { Layout } from "../styles/global";

function Score({ score }) {
  return (
    <ThemeProvider theme={theme}>
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
    </ThemeProvider>
  );
}

const TeamNameArea = styled.div`
  display: flex;
  flex-direction: column;
  padding-top: 20px;
`;

const Team = styled.span`
  margin: 0 20px 10px;
  font-size: 40px;
  color: ${(props) =>
    props.score ? props.theme.highlightColor : props.theme.mainFontColor};
`;

const Vs = styled.span`
  margin: 0 20px;
  color: #aaa;
  font-size: 30px;
`;

const ScoreArea = styled.div`
  background-color: black;
  background-color: rgba(0, 0, 0, 0.8);
  display: flex;
  justify-content: center;
  align-items: center;
  padding: 0 0 20px;
  border-bottom: 2px solid #777;
`;

const Player = styled.span`
  color: ${(props) => props.theme.highlightColor};
  visibility: ${(props) => {
    if (props.visibility === "hidden") return "hidden";
  }};
`;

export default Score;
