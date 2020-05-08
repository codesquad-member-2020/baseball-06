import React from "react";
import styled, { ThemeProvider } from "styled-components";
import theme from "../../styles/theme";
import Score from "../Score";
import Title from "../title";
import InningStatus from "./InningStatus";
import PlayerInfo from "./PlayerInfo";
import { mock } from "../../mock";
import { Layout } from "../../styles/global";

function Header() {
  const score = mock.updatedBaseman.updatedScore;
  const playingStatus = mock.playingStatus;
  const inningStatus = mock.inningStatus;
  const updatedPlayer = mock.updatedBaseman.updatedPlayer;

  return (
    <HeaderWrap>
      <InningStatus inningStatus={inningStatus} />
      <div>
        <Title type={"sub"} />
        <Score score={score} />
      </div>
      <PlayerInfo updatedPlayer={updatedPlayer} />
    </HeaderWrap>
  );
}

const HeaderWrap = styled.div`
  ${Layout}
  justify-content:space-between;
  padding: 0 40px;
  background-color: rgba(0, 0, 0, 0.8);
  border-bottom: 2px solid #777;
`;
export default Header;
