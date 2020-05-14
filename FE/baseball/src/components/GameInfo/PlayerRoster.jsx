import React, { useContext, useReducer, useMemo, useEffect } from "react";
import styled, { ThemeProvider } from "styled-components";
import theme from "../../styles/theme";
import TitleHeader from "../Header/TitleHeader";
import { GlobalStyle, Background, BackgroundImg } from "../../styles/global";

import { BaseballContext, SET_TEAM_NAME } from "../../store/Store";

function PlayerRoster({ location }) {
  const TITLE_TEXT = "선수명단";
  const { dispatch } = useContext(BaseballContext);

  useEffect(() => {
    if (!location.selectedTeamInfo) return;

    const { selectedTeamInfo } = location;
    dispatch({ type: SET_TEAM_NAME, payload: selectedTeamInfo });
  }, [location]);

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
