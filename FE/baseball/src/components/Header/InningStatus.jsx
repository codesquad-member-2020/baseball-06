import React, { useContext } from "react";
import styled from "styled-components";
import { BaseballContext } from "../../store/Store";

function InningStatus() {
  const { inningStatus, inningRound } = useContext(BaseballContext);
  console.log(inningStatus, inningRound);
  const { id, strike, ball, out } = inningStatus;
  const { index, type } = inningRound;

  const inningType = {
    EARLY: "초",
  };

  return (
    <InningStatusWrap>
      <Turn>
        <TurnSpan>{index}</TurnSpan>
        <TurnSpan>회</TurnSpan>
        <TurnSpan>{inningType[type]}</TurnSpan>
        <TurnSpan> 수비</TurnSpan>
      </Turn>

      <div>
        <ResultArea>
          <ResultTitle>S</ResultTitle>
          <ResultBall>
            {Array(strike)
              .fill()
              .map((_, i) => (
                <Ball key={"strike" + id + i} result={"strike"} />
              ))}
          </ResultBall>
        </ResultArea>
        <ResultArea>
          <ResultTitle>B</ResultTitle>
          <ResultBall>
            {Array(ball)
              .fill()
              .map((_, i) => (
                <Ball key={"ball" + id + i} result={"ball"} />
              ))}
          </ResultBall>
        </ResultArea>
        <ResultArea>
          <ResultTitle>O</ResultTitle>
          <ResultBall>
            {Array(out)
              .fill()
              .map((_, i) => (
                <Ball key={"out" + id + i} result={"out"} />
              ))}
          </ResultBall>
        </ResultArea>
      </div>
    </InningStatusWrap>
  );
}

const InningStatusWrap = styled.div`
  position: absolute;
  top: 0;
  left: 0;
  padding: 18px 35px;
`;

const ballColor = {
  strike: "#ffef0f",
  ball: "#08a625",
  out: "#ff0505",
};

const ResultArea = styled.div`
  display: flex;
  align-items: center;
  margin: 2px 0;
`;

const ResultTitle = styled.span`
  margin: 0 15px;
  width: 10px;
  font-size: 18px;
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
  font-size: 25px;
  text-align: left;
  margin-bottom: 15px;
`;

const TurnSpan = styled.span`
  color: ${(props) => props.theme.mainFontColor};
`;

export default InningStatus;
