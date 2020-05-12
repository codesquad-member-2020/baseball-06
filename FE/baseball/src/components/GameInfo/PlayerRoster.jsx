import React, { createContext, useReducer, useMemo } from "react";
import styled, { ThemeProvider } from "styled-components";
import { GlobalStyle, Background } from "../../styles/global";

function PlayerRoster() {
  return (
    <>
      <GlobalStyle />
      <Background>선수명단</Background>
    </>
  );
}

export default PlayerRoster;
