import React, { createContext, useContext, useEffect } from "react";
import styled, { ThemeProvider } from "styled-components";
import theme from "../../styles/theme";
import PlayGround from "./PlayGround";
import Header from "../Header/Header";
import { mock } from "../../mock/mock";
import { INNING_INFO_URL } from "../../constants/url";
import { BaseballContext, SET_TEAM_NAME } from "../../store/Store";
import fetchData from "../../useFetch";

import { GlobalStyle, Background } from "../../styles/global";

export const SET_INNING_INFO = "SET_INNING_INFO ";

export const BaseBallContext = createContext();

function Defense({ location }) {
  const { dispatch } = useContext(BaseballContext);

  useEffect(() => {
    if (!location.teamInfo) return;

    const { payload } = location.teamInfo;
    dispatch({ type: SET_TEAM_NAME, payload });
  }, [location]);

  return (
    <ThemeProvider theme={theme}>
      <GlobalStyle />
      <Background>
        <Header />
        <PlayGround></PlayGround>
      </Background>
    </ThemeProvider>
  );
}

export default Defense;
