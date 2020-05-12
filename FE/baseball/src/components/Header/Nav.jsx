import React, { createContext, useReducer, useMemo } from "react";
import styled, { ThemeProvider } from "styled-components";
import {
  GlobalStyle,
  Background,
  MoreBtn,
  MoreBtnText,
} from "../../styles/global";
import {
  SideBoxWrap,
  SideBox,
  SideBoxBtn,
  SideBoxBtnText,
} from "../../styles/sideBox";

function Nav() {
  return (
    <NavWrap>
      <NavContainer>
        <LinkList>
          <NavLink>상세 점수</NavLink>
          <NavLink>선수 명단</NavLink>
          <NavLink>게임 진행</NavLink>
        </LinkList>
      </NavContainer>
      <NavMoreBtn>
        <NavMoreBtnText>Nav </NavMoreBtnText>
      </NavMoreBtn>
    </NavWrap>
  );
}

const NavWrap = styled.div`
  display: flex;
  flex-direction: column;
  position: absolute;
  text-align: -webkit-right;
  height: 76px;
  width: 100%;
  z-index: 1;
`;

const NavMoreBtn = styled.button`
  ${MoreBtn}
  margin-right:80px;
`;

const NavMoreBtnText = styled.button`
  ${MoreBtnText}
`;

const NavContainer = styled.div`
  width: 100%;
  height: 100%;

  background: #212121;
  box-shadow: 0 0 8px rgba(0, 0, 0, 0.1);
`;

const LinkList = styled.ul`
  margin: 0 auto;

  display: flex;
  align-items: center;
  justify-content: space-around;
  width: 950px;
  :after {
    color: rgba(255, 255, 255, 0.54);
    background: #000;
    box-shadow: 0 0 8px rgba(255, 255, 255, 0.1);
  }
`;

const NavLink = styled.li`
  width: calc(90% / 3);
  height: 36px;
  text-align: center;
  line-height: 2.2;
  display: block;
  margin: 10px;
  border-radius: 2px;
  -webkit-transition: all 300ms;
  transition: all 300ms;
  cursor: pointer;

  color: rgba(255, 255, 255, 0.54);
  box-shadow: 0 0 1px rgba(255, 255, 255, 0.54);
  &:hover {
    color: #fff;
    color: rgba(33, 33, 33, 1);
    box-shadow: 0 5px 8px rgba(0, 0, 0, 0.5);
    background: #eceff1;
    background: -webkit-linear-gradient(left, #eceff1 0%, #b0bec5 100%);
    background: linear-gradient(to right, #eceff1 0%, #b0bec5 100%);
    filter: progid:DXImageTransform.Microsoft.gradient(startColorstr='#ECEFF1',endColorstr='#B0BEC5',GradientType=1);
    background-size: 400%;
    -webkit-animation: Gradient 1s ease infinite;
    animation: Gradient 1s ease infinite;
  }
`;

export default Nav;
