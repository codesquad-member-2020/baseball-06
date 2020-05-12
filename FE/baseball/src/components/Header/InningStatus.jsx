import React, { useContext } from "react";
import styled from "styled-components";
import { BaseBallContext } from "../GameProgression/Defense";

function InningStatus() {
  const { inningStatus } = useContext(BaseBallContext);
  console.log(inningStatus);
  const { strike, ball, out, inningNum, inningType } = inningStatus;
  return (
    <InningStatusWrap>
      <Turn>
        <TurnSpan>{inningNum}</TurnSpan>
        <TurnSpan>회</TurnSpan>
        <TurnSpan>{inningType}</TurnSpan>
        <TurnSpan> 수비</TurnSpan>
      </Turn>

      <Gameprogress>
        <ResultArea>
          <ResultTitle>S</ResultTitle>
          <ResultBall>
            {Array(strike)
              .fill()
              .map((_, i) => (
                <Ball key={"strike" + i} result={"strike"} />
              ))}
          </ResultBall>
        </ResultArea>
        <ResultArea>
          <ResultTitle>B</ResultTitle>
          <ResultBall>
            {Array(ball)
              .fill()
              .map((_, i) => (
                <Ball key={"ball" + i} result={"ball"} />
              ))}
          </ResultBall>
        </ResultArea>
        <ResultArea>
          <ResultTitle>O</ResultTitle>
          <ResultBall>
            {Array(out)
              .fill()
              .map((_, i) => (
                <Ball key={"out" + i} result={"out"} />
              ))}
          </ResultBall>
        </ResultArea>
      </Gameprogress>
    </InningStatusWrap>
  );
}

const InningStatusWrap = styled.div``;

const ballColor = {
  strike: "#ffef0f",
  ball: "#08a625",
  out: "#ff0505",
};

const Gameprogress = styled.div`
  /* position: absolute;
  top: 50px;
  left: 10px; */
`;

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

const Turn = styled.div`
  font-size: 28px;
  margin-bottom: 15px;
`;

const TurnSpan = styled.span`
  color: ${(props) => props.theme.mainFontColor};
`;

export default InningStatus;
