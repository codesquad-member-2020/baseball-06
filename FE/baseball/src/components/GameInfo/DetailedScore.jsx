import React, { createContext, useReducer, useMemo } from "react";
import styled, { ThemeProvider } from "styled-components";
import { GlobalStyle, Background, BackgroundImg } from "../../styles/global";

function DetailedScore() {
  return (
    <>
      <GlobalStyle />
      <Background>상세점수</Background>
    </>
  );
}

export default DetailedScore;
