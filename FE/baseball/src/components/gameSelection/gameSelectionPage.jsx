import React, { useState, useReducer } from "react";
import styled, { ThemeProvider } from "styled-components";
import theme from "../../styles/theme";
import Title from "../Header/title";
import GameSelection from "./GameSelection";
import { Scroll } from "../../styles/global";
import {
  GlobalStyle,
  Layout,
  Background,
  BackgroundImg,
} from "../../styles/global";
import { gameSelectionMock } from "../../gameSelectionMock";

// const initialState = {
//   message: "참가할 게임을 선택하세요!",
//   teams: "",
// };

// const reducer = (state, action) => {
//   switch (action.type) {
//     case "gameSelection":
//       console.log(action);
//       return {
//         ...state,
//         message: action.message,
//       };
//   }
// };

function GameSelectionPage({ history }) {
  // const [state, dispatch] = useReducer(reducer, initialState);

  const [message, setMessage] = useState("참가할 게임을 선택하세요!");
  const [teams, setTeams] = useState("");

  return (
    <ThemeProvider theme={theme}>
      <GlobalStyle />
      <Background>
        <BackgroundImg>
          <Title />
          <Container>
            <MessageArea>{message}</MessageArea>
            <GameSelectionContainer>
              {gameSelectionMock.map((teams) => (
                <GameSelection key={teams.id} teams={teams} history={history} />
              ))}
            </GameSelectionContainer>
          </Container>
        </BackgroundImg>
      </Background>
    </ThemeProvider>
  );
}

const Container = styled.main`
  ${Layout};
  flex-direction: column;
`;

const MessageArea = styled.div`
  margin: 15px;
  color: ${(props) => props.theme.mainFontColor};
  font-size: 25px;
`;

const GameSelectionContainer = styled.div`
  margin: 30px 0 0 35px;
  width: 548px;
  height: 400px;
  overflow: hidden;
  &:hover {
    overflow: scroll;
    overflow-x: hidden;
    ${Scroll}
  }
`;

export default GameSelectionPage;
