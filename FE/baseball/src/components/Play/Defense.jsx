import React from "react";
import styled, { ThemeProvider } from "styled-components";
import theme from "../../styles/theme";
import Score from "../Score";
import PlayGround from "./PlayGround";
import Title from "../title";
import InningStatus from "./InningStatus";
import PlayerInfo from "./PlayerInfo";
import { mock } from "../../mock";

import { GlobalStyle, Background } from "../../styles/global";

function Defense() {
  const score = mock.updatedBaseman.updatedScore;
  const playingStatus = mock.playingStatus;
  const inningStatus = mock.inningStatus;
  const updatedPlayer = mock.updatedPlayer;

  return (
    <ThemeProvider theme={theme}>
      <GlobalStyle />
      <Background>
        <Title type={"sub"} />
        <Score score={score} />
        <InningStatus inningStatus={inningStatus} />
        <PlayerInfo updatedPlayer={updatedPlayer} />
        <PlayGround playingStatus={playingStatus} />
      </Background>
    </ThemeProvider>
  );
}

export default Defense;
