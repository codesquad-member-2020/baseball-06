import React, { createContext, useEffect, useContext } from "react";
import theme from "../../styles/theme";
import styled, { ThemeProvider } from "styled-components";
import TitleHeader from "../Header/TitleHeader";
import { GlobalStyle, Background, BackgroundImg } from "../../styles/global";
import DetailedScore from "./DetailedScore";

import { BaseballContext, SET_TEAM_NAME } from "../../store/Store";

function DetailedScorePage({ location }) {
  const TITLE_TEXT = "상세 점수";
  const { dispatch } = useContext(BaseballContext);

  useEffect(() => {
    if (!location.selectedTeamInfo) return;

    const { selectedTeamInfo, pathname } = location;
    dispatch({ type: SET_TEAM_NAME, payload: selectedTeamInfo });
  }, [location]);

  // 분리하기 공통으로 각 페이지마다 사용

  return (
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
  );
}

export default DetailedScorePage;
