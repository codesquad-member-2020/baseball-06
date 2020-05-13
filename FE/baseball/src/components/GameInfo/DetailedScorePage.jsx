import React, { createContext, useReducer, useMemo } from "react";
import theme from "../../styles/theme";
import styled, { ThemeProvider } from "styled-components";
import TitleHeader from "../Header/TitleHeader";
import { GlobalStyle, Background, BackgroundImg } from "../../styles/global";
import DetailedScore from './DetailedScore'

export const DetailedScoreContext = createContext({
  dispatch: () => {},
});

function DetailedScorePage() {
  const TITLE_TEXT = "상세 점수";
  const value = useMemo(() => ({}), []);

  return (
    <DetailedScoreContext.Provider value={value}>
      <ThemeProvider theme={theme}>
        <GlobalStyle />
        <Background>
          <BackgroundImg>
          <div>
            <TitleHeader titleText={TITLE_TEXT} />
            <DetailedScore />
            </div>
          </BackgroundImg>
        </Background>
      </ThemeProvider>
    </DetailedScoreContext.Provider>
  );
}

export default DetailedScorePage;
