import React, { useState, useCallback, useRef } from "react";
import styled, { ThemeProvider } from "styled-components";
import { Link } from "react-router-dom";
import {
  GlobalStyle,
  Background,
  MoreBtnStyle,
  MoreBtnTextStyle,
} from "../../styles/global";

function Nav() {
  const OPEN_BTN_TEXT = "Nav ∨";
  const CLOSE_BTN_TEXT = "Close ∧";
  const TRANSITION_PROPERTY = "all .3s ease-in-out";

  const NavWrapRef = useRef();
  const NavContainerRef = useRef();
  const MoreBtnTextRef = useRef();

  const [moreBtnText, setMoreBtnText] = useState(CLOSE_BTN_TEXT);

  const clickMoreBtn = useCallback(() => {
    NavWrapRef.current.style.transition = TRANSITION_PROPERTY;

    const logBoxWidth = NavContainerRef.current.offsetHeight;
    if (moreBtnText === CLOSE_BTN_TEXT) {
      setMoreBtnText(OPEN_BTN_TEXT);
      addTranslate(`-${logBoxWidth}`);
      NavContainerRef.current.style.visibility = "hidden";
    } else {
      NavContainerRef.current.style.visibility = "visible";
      setMoreBtnText(CLOSE_BTN_TEXT);
      addTranslate(0);
    }
  }, [moreBtnText]);

  const addTranslate = (distance) => {
    return (NavWrapRef.current.style.transform = `translateY(${distance}px)`);
  };

  return (
    <NavWrap ref={NavWrapRef}>
      <NavContainer ref={NavContainerRef}>
        <LinkList>
          <NavLink ref={MoreBtnTextRef}>
            <Link to="/">게임 선택 </Link>
          </NavLink>
          <NavLink ref={MoreBtnTextRef}>
            <Link to="/detailedScore">상세 점수 </Link>
          </NavLink>
          <NavLink>
            <Link to="/playerRoster">선수 명단</Link>
          </NavLink>
          <NavLink>
            <Link to="/defense">게임 진행</Link>
          </NavLink>
        </LinkList>
      </NavContainer>
      <NavMoreBtn onClick={clickMoreBtn}>
        <NavMoreBtnText>{moreBtnText}</NavMoreBtnText>
      </NavMoreBtn>
    </NavWrap>
  );
}

const NavWrap = styled.div`
  display: flex;
  flex-direction: column;
  position: absolute;
  text-align: -webkit-left;
  height: 59px;
  width: 100%;
  z-index: 1;
`;

const NavMoreBtn = styled.button`
  ${MoreBtnStyle}
  margin-left:80px;
`;

const NavMoreBtnText = styled.span`
  ${MoreBtnTextStyle}
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
  /* width: calc(90% / 3); */
  padding: 7px 20px;
  /* height: 36px; */
  text-align: center;
  line-height: 2.2;
  display: block;
  /* margin: 10px; */
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
