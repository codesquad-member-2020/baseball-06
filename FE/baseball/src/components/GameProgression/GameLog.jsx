import React, { createContext, useReducer, useMemo } from "react";
import styled, { css } from "styled-components";
import { Scroll } from "../../styles/global";

function GameLog() {
  return (
    <>
      <LogArea>
        <Result>
          <CurrentPlayer>7번 타자 류현진</CurrentPlayer>
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
          <PastPlayer>7번 타자 류현진</PastPlayer>
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
          <PastPlayer>7번 타자 류현진</PastPlayer>
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
          <PastPlayer>7번 타자 류현진</PastPlayer>
          <div></div>
          <div></div>
          <LastResultLog>아웃!</LastResultLog>
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
  grid-auto-rows: minmax(1.9em, auto);
  margin-bottom: 30px;
`;
const LogArea = styled.div`
  position: absolute;
  top: 0;
  right: 0;
  overflow: auto;
  padding: 20px;
  height: 100%;
  width: 300px;
  background-color: ${(props) => props.theme.backgroundColor};
  border-left: ${(props) => props.theme.mainBorder};
  letter-spacing: 3.5px;
  ${Scroll}
`;

const LogOpenBtn = styled.button`
  position: absolute;
  top: 0;
  left: 0;
  width: 10px;
  height: 20px;
  background-color: #bbb;
`;

const Player = css`
  grid-column: 1/3;
  width: 100%;
`;

const CurrentPlayer = styled.div`
  ${Player}
  padding: 5px;
  border: 1px solid red;
  color: ${(props) => props.theme.highlightColor};
`;

const PastPlayer = styled.div`
${Player}
 color: ${(props) => props.theme.subPinkColor};
`;

const Number = styled.span`
  width: 17px;
  height: 17px;
  border-radius: 50%;
  justify-self: center;
  background-color: #fff;
  letter-spacing: 0;
`;

const ResultLog = styled.div`
  justify-self: center;

  color: ${(props) => props.theme.mainFontColor};
`;

const LastResultLog = styled.div`
  justify-self: center;
  color: ${(props) => props.theme.subYellowColor};
`;

const CumulativeLog = styled.div`
  color: ${(props) => props.theme.gray};
`;

export default GameLog;
