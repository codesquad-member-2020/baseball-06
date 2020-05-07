import React from "react";
import styled, { ThemeProvider } from "styled-components";
import theme from "../../styles/theme";

function GameSelection({ teams, history }) {
  // const onClcikTema = (play) => {
  //   console.log(play);
  //   let message = null;
  //   if (play) {
  //     message = "이미 선택된 팀입니다. 다른 팀을 선택해주세요!";
  //   } else {
  //     message = "fetch";
  //   }
  //   dispatch({ tyep: "gameSelection", message: message });
  // };

  const onClickTeam = () => {
    history.push("/Defense");
  };

  return (
    <ThemeProvider theme={theme}>
      <GameSelectionArea>
        <GameNumber>GAME {teams.id}</GameNumber>
        <Teams>
          <Team onClick={onClickTeam}>{teams.team1.name}</Team>

          <Vs>vs</Vs>
          <Team onClick={onClickTeam}>{teams.team2.name}</Team>
        </Teams>
      </GameSelectionArea>
    </ThemeProvider>
  );
}

const GameSelectionArea = styled.div`
  width: 500px;
  height: 100px;
  margin: 20px 0;
  background-color: #b4b4b4;
  opacity: 0.8;
  border-radius: 15px;
`;

const GameNumber = styled.div`
  padding: 10px 0;
  color: ${(props) => props.theme.highlightColor};
  font-size: 18px;
`;

const Teams = styled.div`
  display: flex;
  justify-content: space-around;
`;

const Team = styled.span`
  font-size: 30px;
  cursor: pointer;
  &:hover {
    color: ${(props) => props.theme.highlightColor};
  }
`;

const Vs = styled.span`
  font-size: 30px;
  color: #555;
`;

export default GameSelection;
