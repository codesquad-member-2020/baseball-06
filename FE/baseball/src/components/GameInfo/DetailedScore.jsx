import React, { createContext, useReducer, useMemo } from "react";
import theme from "../../styles/theme";
import styled, { ThemeProvider } from "styled-components";
import TitleHeader from "../Header/TitleHeader";
import { GlobalStyle, Background, BackgroundImg } from "../../styles/global";

export const DetailedScoreContext = createContext({
  dispatch: () => {},
});

function DetailedScore() {
  const TITLE_TEXT = "상세 점수";
  const value = useMemo(() => ({}), []);

  return (
    <DetailedScoreContext.Provider value={value}>
      <ThemeProvider theme={theme}>
        <GlobalStyle />
        <Background>
          <BackgroundImg>
            <TitleHeader titleText={TITLE_TEXT} />
          </BackgroundImg>
        </Background>
      </ThemeProvider>
    </DetailedScoreContext.Provider>
  );
}

export default DetailedScore;
