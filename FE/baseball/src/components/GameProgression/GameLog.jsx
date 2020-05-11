import React, { createContext, useReducer, useMemo } from "react";
import styled from "styled-components";

function GameLog() {
  return (
    <>
      <LogArea>
        <Result>
          <Player current>7번 타자 류현진</Player>
          <div></div>
          <div></div>
          <LastResultLog>안타!</LastResultLog>
          <div></div>
          <Number>1</Number>
          <ResultLog>스트라이크</ResultLog>
          <CumulativeLog>1S 2B</CumulativeLog>
          <Number>1</Number>
          <ResultLog>볼</ResultLog>
          <CumulativeLog>1S 2B</CumulativeLog>
          <Number>1</Number>
          <ResultLog>스트라이크</ResultLog>
          <CumulativeLog>1S 2B</CumulativeLog>
          <LogOpenBtn />
        </Result>
        <Result>
          <Player>7번 타자 류현진</Player>
          <div></div>
          <div></div>
          <LastResultLog>안타!</LastResultLog>
          <div></div>
          <Number>1</Number>
          <ResultLog>스트라이크</ResultLog>
          <CumulativeLog>1S 2B</CumulativeLog>
          <Number>1</Number>
          <ResultLog>볼</ResultLog>
          <CumulativeLog>1S 2B</CumulativeLog>
          <Number>1</Number>
          <ResultLog>스트라이크</ResultLog>
          <CumulativeLog>1S 2B</CumulativeLog>
          <LogOpenBtn />
        </Result>
      </LogArea>
    </>
  );
}

const Result = styled.div`
  display: grid;
  grid-template-columns: 1fr 3fr 2fr;
  justify-items: end;
  align-items: center;
  grid-auto-rows: minmax(2em, auto);
`;
const LogArea = styled.div`
  position: absolute;
  top: 0;
  right: 0;
  /* display: flex; */

  padding: 20px;
  height: 100%;
  width: 280px;
  background-color: ${(props) => props.theme.backgroundColor};
  border-left: ${(props) => props.theme.mainBorder};
  letter-spacing: 3.5px;
`;

const LogOpenBtn = styled.button`
  position: absolute;
  top: 0;
  left: 0;
  width: 10px;
  height: 20px;
  background-color: #bbb;
`;

const Player = styled.div`
  grid-column: 1/3;
  width: 100%;
  color: ${(props) =>
    props.current ? props.theme.highlightColor : props.theme.subPinkColor};
  flex-wrap: wrap;
`;

const Number = styled.span`
  width: 17px;
  height: 17px;
  border-radius: 50%;
  background-color: #fff;
  letter-spacing: 0;
`;

const ResultLog = styled.div`
  justify-self: center;

  color: ${(props) => props.theme.mainFontColor};
`;

const LastResultLog = styled.div`
  justify-self: center;
  color: ${(props) => props.theme.subBlueColor};
`;

const CumulativeLog = styled.div`
  color: ${(props) => props.theme.gray};
`;

export default GameLog;
