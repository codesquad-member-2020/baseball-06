import React, { createContext, useContext, useEffect } from "react";
import { BaseballContext, SET_TEAM_NAME } from "../../store/Store";
import styled, { ThemeProvider } from "styled-components";
import theme from "../../styles/theme";
import PlayGround from "./PlayGround";

import Header from "../Header/Header";
import { mock } from "../../mock/mock";
import GameLog from "./GameLog";

import { GlobalStyle, Background } from "../../styles/global";

export const FETCH_RESULT_INFO = "FETCH_RESULT_INFO";
export const OFFENSE = "offense";

function Offense({ location }) {
  const { dispatch } = useContext(BaseballContext);

  useEffect(() => {
    const { teamType, payload } = location.teamInfo;
    dispatch({ type: SET_TEAM_NAME, teamType, payload });
  }, [location]);

  return (
    <ThemeProvider theme={theme}>
      <GlobalStyle />
      <Background>
        <Header team={OFFENSE} />
        <PlayGround></PlayGround>
      </Background>
    </ThemeProvider>
  );
}

export default Offense;
