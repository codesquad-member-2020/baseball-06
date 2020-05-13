import React, { createContext, useReducer, useMemo } from "react";
import styled, { ThemeProvider } from "styled-components";
import theme from "../../styles/theme";
import TitleHeader from "../Header/TitleHeader";
import { GlobalStyle, Background, BackgroundImg } from "../../styles/global";

function PlayerRoster() {
  const TITLE_TEXT = "선수명단";

  return (
    <ThemeProvider theme={theme}>
      <GlobalStyle />
      <Background>
        <BackgroundImg>
          <TitleHeader titleText={TITLE_TEXT} />
        </BackgroundImg>
      </Background>
    </ThemeProvider>
  );
}

export default PlayerRoster;
