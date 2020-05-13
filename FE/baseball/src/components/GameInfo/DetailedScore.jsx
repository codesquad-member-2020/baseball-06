import React, { createContext, useReducer, useMemo } from "react";
import theme from "../../styles/theme";
import styled, { ThemeProvider } from "styled-components";
import TitleHeader from "../Header/TitleHeader";
import { GlobalStyle, Background, BackgroundImg } from "../../styles/global";

function DetailedScore() {
  return (
    <>
      <ThemeProvider theme={theme}>
        <GlobalStyle />
        <Background>
          <BackgroundImg>
            <TitleHeader />
          </BackgroundImg>
        </Background>
      </ThemeProvider>
    </>
  );
}

export default DetailedScore;
