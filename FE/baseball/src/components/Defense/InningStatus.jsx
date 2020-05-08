import React, { useState } from "react";
import styled, { ThemeProvider } from "styled-components";
import theme from "../../styles/theme";

function InningStatus({ inningStatus }) {
  const { strike, ball, out, inningNum, inningType } = inningStatus;
  return (
    <ThemeProvider theme={theme}>
      <InningStatusWrap>
        <Gameprogress>
          <ResultArea>
            <ResultTitle>S</ResultTitle>
            <ResultBall>
              {Array(strike)
                .fill()
                .map((_) => (
                  <Ball result={"strike"} />
                ))}
            </ResultBall>
          </ResultArea>
          <ResultArea>
            <ResultTitle>B</ResultTitle>
            <ResultBall>
              {Array(ball)
                .fill()
                .map((_) => (
                  <Ball result={"ball"} />
                ))}
            </ResultBall>
          </ResultArea>
          <ResultArea>
            <ResultTitle>O</ResultTitle>
            <ResultBall>
              {Array(out)
                .fill()
                .map((_) => (
                  <Ball result={"out"} />
                ))}
            </ResultBall>
          </ResultArea>
        </Gameprogress>

        <Turn>
          <TurnSpan>{inningNum}</TurnSpan>
          <TurnSpan>회</TurnSpan>
          <TurnSpan>{inningType}</TurnSpan>
          <TurnSpan> 수비</TurnSpan>
        </Turn>
      </InningStatusWrap>
    </ThemeProvider>
  );
}

const ballColor = {
  strike: "#ffef0f",
  ball: "#08a625",
  out: "#ff0505",
};

const Gameprogress = styled.div``;

const ResultArea = styled.div`
  display: flex;
  align-items: center;
  margin: 2px 0;
`;

const ResultTitle = styled.span`
  margin: 0 15px;
  width: 10px;
  font-size: 20px;
  color: ${(props) => props.theme.mainFontColor};
`;

const ResultBall = styled.div`
  display: flex;
`;

const Ball = styled.span`
  display: inline-block;
  margin: 0 10px;
  width: 15px;
  height: 15px;
  background-color: ${(props) => ballColor[props.result]};
  border-radius: 50%;
`;

const InningStatusWrap = styled.div`
  display: flex;
  justify-content: space-between;
`;

const Turn = styled.div`
  font-size: 30px;
  margin: 15px;
`;

const TurnSpan = styled.span`
  color: ${(props) => props.theme.mainFontColor};
`;

export default InningStatus;
