import React from "react";
import styled, { ThemeProvider } from "styled-components";
import theme from "../../styles/theme";
// import Score from "../Score";
import PlayGround from "./PlayGround";
// import Title from "../title";
// import InningStatus from "./InningStatus";
// import PlayerInfo from "./PlayerInfo";
import Header from "./Header";
import { mock } from "../../mock";

import { GlobalStyle, Background } from "../../styles/global";

function Defense() {
  const score = mock.updatedBaseman.updatedScore;
  const playingStatus = mock.playingStatus;
  const inningStatus = mock.inningStatus;
  const updatedPlayer = mock.updatedBaseman.updatedPlayer;
  return (
    <ThemeProvider theme={theme}>
      <GlobalStyle />
      <Background>
        <Header />
        {/* <Title type={"sub"} />
        <Score score={score} /> */}
        <PlayGround playingStatus={playingStatus} />
      </Background>
    </ThemeProvider>
  );
}

export default Defense;