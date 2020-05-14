import React from "react";
import styled from "styled-components";
import Score from "./Score";
import Title from "./title";
import InningStatus from "./InningStatus";
import PlayerInfo from "./PlayerInfo";
import Nav from "./Nav";
import { Layout } from "../../styles/global";

function TitleHeader({ titleText }) {
  return (
    <div>
      <HeaderWrap>
        <Title titleText={titleText} />
      </HeaderWrap>
      <Nav />
    </div>
  );
}

const HeaderWrap = styled.div`
  padding: 32px 0px;
  background-color: ${(props) => props.theme.backgroundColor};
  border-bottom: ${(props) => props.theme.mainBorder};
`;
export default TitleHeader;
