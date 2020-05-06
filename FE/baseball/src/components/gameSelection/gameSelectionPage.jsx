import React, { useState } from "react";
import styled, { ThemeProvider } from "styled-components";
import theme from "../../styles/theme";
import Title from "../title";
import GameSelection from "./GameSelection";
import { GlobalStyle, Layout } from "../../styles/global";
import { gameSelectionMock } from "../../gameSelectionMock";

function GameSelectionPage() {
  const [message, setMessage] = useState("참가할 게임을 선택하세요!");
  const [teams, setTeams] = useState("");

  {
  }
  return (
    <>
      <ThemeProvider theme={theme}>
        <GlobalStyle />
        <Title />
        <Container>
          <MessageArea>{message}</MessageArea>
          <GameSelectionContainer>
            {gameSelectionMock.map((teams) => (
              <GameSelection teams={teams} />
            ))}
          </GameSelectionContainer>
        </Container>
      </ThemeProvider>
    </>
  );
}

const Container = styled.main`
  ${Layout};
  flex-direction: column;

  /* width: 100vw; */
  /* height: 100vh; */
`;

const MessageArea = styled.div`
  margin: 30px;
  color: ${(props) => props.theme.mainFontColor};
  font-size: 20px;
`;

const GameSelectionContainer = styled.div`
  margin-left: 27px;
  width: 548px;
  height: 400px;
  overflow: hidden;
  &:hover {
    overflow: scroll;
    overflow-x: hidden;
    ::-webkit-scrollbar-track {
      border-radius: 10px;

      background-color: #cccccc;
    }

    ::-webkit-scrollbar {
      width: 12px;
      border-radius: 10px;
      background-color: #f5f5f5;
    }

    ::-webkit-scrollbar-thumb {
      border-radius: 10px;

      background-image: -webkit-linear-gradient(
        90deg,
        rgba(0, 0, 0, 1) 0%,
        rgba(0, 0, 0, 1) 25%,
        transparent 100%,
        rgba(0, 0, 0, 1) 75%,
        transparent
      );

      background-color: #555;
    }
  }
`;

export default GameSelectionPage;
