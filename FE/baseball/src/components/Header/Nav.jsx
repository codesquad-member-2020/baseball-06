import React, { createContext, useReducer, useMemo } from "react";
import styled, { ThemeProvider } from "styled-components";
import { GlobalStyle, Background } from "../../styles/global";
import {
  SideBoxWrap,
  SideBox,
  SideBoxBtn,
  SideBoxBtnText,
} from "../../styles/sideBox";

function Nav() {
  return (
    // <NavWrap>
    //   <SideBoxBtn>
    //     <SideBoxBtnText></SideBoxBtnText>
    //   </SideBoxBtn>
    //   <SideBox>
    //     <LinkList>
    //       <NavLink>dd</NavLink>
    //       <NavLink>dd</NavLink>
    //       <NavLink>dd</NavLink>
    //       <NavLink>dd</NavLink>
    //       <NavLink>dd</NavLink>
    //     </LinkList>
    //   </SideBox>
    // </NavWrap>
    <NavWrap>
      <LinkList>
        <NavLink>dd</NavLink>
        <NavLink>dd</NavLink>
        <NavLink>dd</NavLink>
        <NavLink>dd</NavLink>
        <NavLink>dd</NavLink>
      </LinkList>
    </NavWrap>
  );
}

// const NavWrap = styled.div`
//   ${SideBoxWrap}
//   right: 0px;
//   width: 320px;
// `;
const NavWrap = styled.div`
  /* justify-content: flex-end; */
  align-items: center;
  width: 100%;
  height: 40px;
`;

const LinkList = styled.ul`
  display: flex;
  align-items: center;
  justify-content: space-around;
  :after {
    color: rgba(255, 255, 255, 0.54);
    background: #000;
    box-shadow: 0 0 8px rgba(255, 255, 255, 0.1);
  }

  background: #212121;
  box-shadow: 0 0 8px rgba(0, 0, 0, 0.1);
`;

const NavLink = styled.li`
  width: 150px;
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
    /* box-shadow: 0 5px 8px rgba(63, 81, 181, 0.5);
    background: #ffc107;
    background: -webkit-linear-gradient(
      left,
      #ffc107 0%,
      #f50057 50%,
      #3f51b5 100%
    );
    background: linear-gradient(
      to right,
      #ffc107 0%,
      #f50057 50%,
      #3f51b5 100%
    );
    filter: progid:DXImageTransform.Microsoft.gradient(startColorstr='#FFC107',endColorstr='#3F51B5',GradientType=1);
    background-size: 400%;
    -webkit-animation: Gradient 5s ease infinite;
    animation: Gradient 5s ease infinite; */
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

const NavListSpan = styled.span`
  font-size: 18px;
  line-height: 1;
  vertical-align: middle;
`;

// const NavList = styled.ul`
//   padding: 7px 15px;
//   background: teal;
//   border: 1px solid #006d6d;
//   border-radius: 50em;
//   color: #fff;
//   &:hover {
//     color: #0088a9;
//   }
// `;

export default Nav;
