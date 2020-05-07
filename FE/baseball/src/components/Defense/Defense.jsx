import React from "react";
import styled, { ThemeProvider } from "styled-components";
import theme from "../../styles/theme";
import Score from "../Score";
import Title from "../title";
import { mock } from "../../mock";

import { GlobalStyle, Layout, Background } from "../../styles/global";

function Defense() {
  const score = mock.updatedBaseman.updatedScore;

  return (
    <ThemeProvider theme={theme}>
      <GlobalStyle />
      <Background>
        <Title type={"sub"} />
        <Score score={score} />
      </Background>
    </ThemeProvider>
  );
}

export default Defense;
