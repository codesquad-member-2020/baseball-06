import React, { useState } from "react";
import styled from "styled-components";

function GameSelection({ teams }) {
  return (
    <GameSelectionArea>
      <GameNumber>GAME {teams.id}</GameNumber>
      <Teams>
        <Team>{teams.player1}</Team>
        <Vs>vs</Vs>
        <Team>{teams.player2}</Team>
      </Teams>
    </GameSelectionArea>
  );
}

const GameSelectionArea = styled.div`
  width: 500px;
  height: 100px;
  margin: 20px 0;
  background-color: #b4b4b4;
  border-radius: 15px;
  opacity: 0.8;
`;

const GameNumber = styled.div`
  padding: 10px 0;
  color: #f70404;
  font-size: 18px;
`;

const Teams = styled.div`
  display: flex;
  justify-content: space-around;
`;

const Team = styled.span`
  font-weight: bold;
  font-size: 30px;
  cursor: pointer;
  &:hover {
    color: #f70404;
  }
`;

const Vs = styled.span`
  font-weight: bold;
  font-size: 30px;
  color: #555;
`;

export default GameSelection;
