import React from "react";
import styled from "styled-components";
import Score from "./Score";
import Title from "./title";
import InningStatus from "./InningStatus";
import PlayerInfo from "./PlayerInfo";
import Nav from "./Nav";
import { mock } from "../../mock";
import { Layout } from "../../styles/global";

function Header() {
  return (
    <div>
      <HeaderWrap>
        <InningStatus />
        <div>
          <Title type={"sub"} />
          <Score />
        </div>
        <PlayerInfo />
      </HeaderWrap>
      <Nav />
    </div>
  );
}

const HeaderWrap = styled.div`
  ${Layout}
  justify-content:space-between;
  padding: 0 40px;
  background-color: ${(props) => props.theme.backgroundColor};
  border-bottom: ${(props) => props.theme.mainBorder};
`;
export default Header;
