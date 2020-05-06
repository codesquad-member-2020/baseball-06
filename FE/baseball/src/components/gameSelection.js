import React, { useState } from "react";
import styled, { ThemeProvider } from "styled-components";
import theme from "../styles/theme";
import { GlobalStyle, Layout } from "../styles/global";
import { gameSelectionMock } from "../gameSelectionMock";

function GameSelection() {
  const [message, setMessage] = useState("참가할 게임을 선택하세요!");
  const [teams, setTeams] = useState("");
  const title = "BASEBALL GAME ONLINE";

  {
  }
  return (
    <>
      <ThemeProvider theme={theme}>
        <GlobalStyle />
        <Title>{title}</Title>
        <Container>
          <MessageArea>{message}</MessageArea>
          {gameSelectionMock.map((temas) => {
            return (
              <GameSelectionArea>
                <GameNumber>GAME {temas.id}</GameNumber>
                <Teams>
                  <Team>{temas.player1}</Team>
                  <Vs>vs</Vs>
                  <Team>{temas.player2}</Team>
                </Teams>
              </GameSelectionArea>
            );
          })}
        </Container>
      </ThemeProvider>
    </>
  );
}

const Title = styled.h1`
  padding: 30px;
  font-weight: bold;
  font-size: 40px;
`;

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

const GameSelectionArea = styled.div`
  width: 500px;
  height: 100px;
  margin: 20px 0;
  background-color: #b7b7b3;
  border-radius: 15px;
  opacity: 0.8;
`;

const GameNumber = styled.div`
  color: red;
  text-align: center;
`;

const Teams = styled.div`
  display: flex;
  justify-content: space-around;
`;

const Team = styled.span`
  font-weight: bold;
  font-size: 20px;
`;

const Vs = styled.span`
  font-size: 15px;
`;

export default GameSelection;
