import React, {
  createContext,
  useReducer,
  useMemo,
  useCallback,
  useRef,
  useState,
} from "react";
import styled, { css } from "styled-components";
import { Scroll } from "../../styles/global";

function GameLog() {
  const logRef = useRef();
  const openLog = useCallback(() => {
    logRef.current.style.transition = "all .3s ease-in-out";
    logRef.current.style.transform = "translateX(-300px)";
  }, []);

  return (
    <LogWrap ref={logRef}>
      <LogOpenBtn onClick={openLog}>open</LogOpenBtn>
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
        </Result>
      </LogArea>
    </LogWrap>
  );
}

const LogWrap = styled.div`
  display: flex;
  align-items: center;
  width: 320px;
  position: absolute;
  top: 0;
  right: -300px;
  height: 100%;
`;

const Result = styled.div`
  display: grid;
  grid-template-columns: 1fr 3fr 2fr;
  justify-items: end;
  align-items: center;
  grid-auto-rows: minmax(1.9em, auto);
  margin-bottom: 30px;
`;
const LogArea = styled.div`
  overflow: auto;
  padding: 20px;
  height: 100%;
  width: 300px;
  background-color: ${(props) => props.theme.backgroundColor};
  letter-spacing: 3.5px;
  ${Scroll}
`;

const LogOpenBtn = styled.button`
  width: 15px;
  height: 50px;

  border-radius: 10%;

  background-image: linear-gradient(
    to right,
    #ece9e6 0%,
    #ffffff 51%,
    #ece9e6 100%
  );
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
