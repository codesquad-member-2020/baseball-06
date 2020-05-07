import React, { useState, useReducer } from "react";
import styled, { ThemeProvider } from "styled-components";
import theme from "../../styles/theme";
import Title from "../title";
import GameSelection from "./GameSelection";
import { GlobalStyle, Layout, Background } from "../../styles/global";
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

function GameSelectionPage() {
  // const [state, dispatch] = useReducer(reducer, initialState);

  const [message, setMessage] = useState("참가할 게임을 선택하세요!");
  const [teams, setTeams] = useState("");

  {
  }
  return (
    <ThemeProvider theme={theme}>
      <GlobalStyle />
      <Background>
        <Title />
        <Container>
          <MessageArea>{message}</MessageArea>
          <GameSelectionContainer>
            {gameSelectionMock.map((teams) => (
              <GameSelection key={teams.id} teams={teams} />
            ))}
          </GameSelectionContainer>
        </Container>
      </Background>
    </ThemeProvider>
  );
}

const Container = styled.main`
  ${Layout};
  flex-direction: column;
`;

const MessageArea = styled.div`
  margin: 30px;
  color: ${(props) => props.theme.mainFontColor};
  font-size: 25px;
`;

const GameSelectionContainer = styled.div`
  margin-left: 35px;
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

//변경이 일어나면 사이즈가 커지니까 메서드 하나만 바껴도 영향이 많아짐수정해야 하는 범위가 늘어난다
//
