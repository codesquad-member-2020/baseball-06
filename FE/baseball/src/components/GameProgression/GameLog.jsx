import React, {
  createContext,
  useReducer,
  useMemo,
  useEffect,
  useCallback,
  useRef,
  useState,
} from "react";
import styled, { css } from "styled-components";
import { Scroll, MoreBtnStyle, MoreBtnTextStyle } from "../../styles/global";

function GameLog() {
  const OPEN_BTN_TEXT = "Log ∧";
  const CLOSE_BTN_TEXT = "Close ∨";
  const TRANSITION_PROPERTY = "all .3s ease-in-out";

  const [logBtnText, setLogBtnText] = useState(OPEN_BTN_TEXT);
  const logWrapRef = useRef();
  const logBoxRef = useRef();

  const clickMoreBtn = useCallback(() => {
    logWrapRef.current.style.transition = TRANSITION_PROPERTY;

    const logBoxWidth = logBoxRef.current.offsetWidth;
    if (logBtnText === OPEN_BTN_TEXT) {
      setLogBtnText(CLOSE_BTN_TEXT);
      addTranslate(`-${logBoxWidth}`);
    } else {
      setLogBtnText(OPEN_BTN_TEXT);
      addTranslate(0);
    }
  }, [logBtnText]);

  const addTranslate = (distance) => {
    return (logWrapRef.current.style.transform = `translateX(${distance}px)`);
  };

  return (
    <LogWrap ref={logWrapRef}>
      <LogOpenBtn onClick={clickMoreBtn}>
        <LogBtnText>{logBtnText}</LogBtnText>
      </LogOpenBtn>
      <LogBox ref={logBoxRef}>
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
      </LogBox>
    </LogWrap>
  );
}

const LogWrap = styled.div`
  display: flex;
  align-items: center;
  width: 320px;
  position: absolute;
  top: 0;
  right: -295px;
  height: 100%;
  z-index:2;
`;

const Result = styled.div`
  display: grid;
  grid-template-columns: 1fr 3fr 2fr;
  justify-items: end;
  align-items: center;
  grid-auto-rows: minmax(1.9em, auto);
  margin-bottom: 30px;
`;
const LogBox = styled.div`
  overflow: auto;
  padding: 20px;
  height: 100%;
  width: 300px;
  background-color: ${(props) => props.theme.backgroundColor};
  letter-spacing: 3.5px;
  ${Scroll}
`;

const LogOpenBtn = styled.button`
  ${MoreBtnStyle}
  width: 25px;
  height: 67px;
`;

const LogBtnText = styled.span`
  ${MoreBtnTextStyle}
  transform: rotate(-180deg);
  vertical-align: top;
  writing-mode: tb-rl;
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
