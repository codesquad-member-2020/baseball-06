import React, { useRef, useState, useEffect, useCallback } from "react";
import styled, { ThemeProvider, css, keyframes } from "styled-components";
import theme from "../../styles/theme";
import ground from "../../styles/images/ground.jpg";

const pticherImg =
  "https://ih0.redbubble.net/image.12303453.4706/sticker,375x360.png";
const ballImg =
  "https://www.animatedimages.org/data/media/158/animated-baseball-image-0086.gif";
const img = "http://ih2.redbubble.net/image.12303484.4729/sticker,375x360.png";
// const img =
// "https://images-wixmp-ed30a86b8c4ca887773594c2.wixmp.com/f/bff79450-9f9c-4baf-af12-b6289ab026d8/d5xpfor-f6658e45-58a4-44e4-b204-431b39285355.gif?token=eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1cm46YXBwOiIsImlzcyI6InVybjphcHA6Iiwib2JqIjpbW3sicGF0aCI6IlwvZlwvYmZmNzk0NTAtOWY5Yy00YmFmLWFmMTItYjYyODlhYjAyNmQ4XC9kNXhwZm9yLWY2NjU4ZTQ1LTU4YTQtNDRlNC1iMjA0LTQzMWIzOTI4NTM1NS5naWYifV1dLCJhdWQiOlsidXJuOnNlcnZpY2U6ZmlsZS5kb3dubG9hZCJdfQ.U3JxM9boQ07PxcmUJEqYcM8zqJ_u1TmDaZ_yC8Nku-0";

function PlayGround() {
  const [batterCoord, setBatterCoord] = useState(0);
  const [rotation, setRotation] = useState(187);
  const [top, setTop] = useState(65);
  const [left, setLeft] = useState(43);
  const [deg, setDeg] = useState(-28);

  const [ballTopCoord, setBallTopCoord] = useState(45);
  const [ballLeftCoord, setBallLeftCoord] = useState(55);
  const [hitterDisplay, setHitterDisplay] = useState(true);
  const [resultDisplay, setResultDisplay] = useState(true);
  const [pitchBtnDisplay, setPitchBtnDisplay] = useState("block");
  const [result, setResult] = useState("");
  const batterCoordCount = useRef(0);
  const ballCoord = useRef(0);
  const count = useRef(0);
  const batter = useRef();
  const onPitch = () => {
    pitchAnimation();
  };

  const pitchAnimation = () => {
    let ballRaf = null;
    const ballEndCoord = 150;
    setPitchBtnDisplay("none");
    setResultDisplay("block");
    setResult("기다려");

    if (ballCoord.current > 100) {
      batter.current.style.transform = "rotateY(140deg)";
      setTimeout(() => (batter.current.style.transform = "rotateY(0deg)"), 100);
    }
    if (ballCoord.current > ballEndCoord) {
      ballCoord.current = 0;
      setBallTopCoord(45);
      setBallLeftCoord(55);
      cancelAnimationFrame(ballRaf);
      fetch("http://15.164.101.161:8080/dev/dotest")
        .then((res) => res.json())
        .then((data) => {
          setResult(data.body.battingResult);
          setTimeout(() => {
            setPitchBtnDisplay("block");
            setResultDisplay("none");
          }, 1000);
          if (data.body.battingResult === "HIT") {
            count.current++;
            setHitterDisplay(false);
            setTimeout(() => setHitterDisplay(true), 1000);
            moveBatter();
          }
        });

      return;
    }
    ballCoord.current += 5;
    setBallTopCoord((prevState) => prevState + 5);
    setBallLeftCoord((prevState) => prevState - 2.5);
    ballRaf = requestAnimationFrame(pitchAnimation);
  };

  const moveBatter = () => {
    const movingSpeed = 13;
    const endCoord = 385;
    let batterRaf = null;

    if (batterCoordCount.current > endCoord) {
      batterCoordCount.current = 0;
      return cancelAnimationFrame(batterRaf);
    }
    setBatterCoord(batterCoordCount.current);

    batterCoordCount.current += movingSpeed;
    batterRaf = requestAnimationFrame(moveBatter);
  };

  return (
    <ThemeProvider theme={theme}>
      <GroundArea>
        <ResultBox display={resultDisplay}>{result}!!</ResultBox>
        <PitcherArea>
          <Pitcher></Pitcher>
          <Ball ballTopCoord={ballTopCoord} ballLeftCoord={ballLeftCoord} />
        </PitcherArea>
        <Ground top={65} left={43} deg={-28}>
          <Player1
            ref={batter}
            coord={batterCoord}
            count={count}
            hitterDisplay={hitterDisplay}
          />
        </Ground>
        <Ground top={65} left={43} deg={-28}>
          <Player2 coord={batterCoord} count={count} displayCount={1} />
        </Ground>
        <Ground top={31} left={50} deg={-162}>
          <Player3 coord={batterCoord} count={count} displayCount={2} />
        </Ground>
        <Ground top={29} left={28} deg={-201}>
          <Player3 coord={batterCoord} count={count} displayCount={3} />
        </Ground>
        <Ground top={60} left={27} deg={30}>
          <Player2 coord={batterCoord} count={count} displayCount={4} />
        </Ground>
        <PitchBtnBox display={pitchBtnDisplay} onClick={onPitch}>
          Pitch
        </PitchBtnBox>
      </GroundArea>
    </ThemeProvider>
  );
}

// const batterHit = keyframes`
//   0% {
//     transform: rotateY(0deg);
//   }
//   50% {
//     transform: rotateY(180deg);
//   }
//   100% {
//     transform: rotateY(0deg);
//   }
//   `;

const box = css`
  margin-top: 20px;
  padding: 10px 0;
  width: 263px;
  height: 70px;
  display: ${(props) => (props.display === "block" ? "block" : "none")};
  text-align: center;
  font-size: 40px;
  color: ${(props) => props.theme.mainFontColor};
`;

const ResultBox = styled.div`
  ${box};
  background-color: ${(props) => props.theme.backgroundColor};
  border: ${(props) => "3px dashed" + props.theme.highlightColor};
`;

const GroundArea = styled.div`
  position: relative;
  flex: 1;
  display: flex;
  justify-content: center;
`;

const Ball = styled.div`
  width: 18px;
  height: 18px;
  background: no-repeat url(${ballImg});
  background-position: center;
  background-size: cover;
  position: absolute;
  top: ${(props) => props.ballTopCoord + "px"};
  left: ${(props) => props.ballLeftCoord + "px"};
`;

const Ground = styled.div`
  position: absolute;
  width: 397px;
  top: ${(props) => props.top + "%"};
  left: ${(props) => props.left + "%"};
  transform: ${(props) => `rotate(${props.deg}deg)`};
`;

const PitcherArea = styled.div`
  position: absolute;
  border: 1px solid red;
  width: 80px;
  height: 89px;
  top: 253px;
  left: 717px;
`;

const Pitcher = styled.div`
  width: 100%;
  height: 100%;
  background: no-repeat url(${pticherImg});
  background-position: center;
  background-size: cover;
`;

const Player = css`
  width: 80px;
  height: 100px;
  background: no-repeat url(${img});
  background-position: center;
  background-size: cover;
`;

const Player1 = styled.div`
  display: ${(props) => (props.hitterDisplay ? "block" : "none")};
  ${Player}
`;

const Player2 = styled.div`
  display: ${(props) =>
    props.count.current >= props.displayCount ? "block" : "none"};
 ${Player}
  transform: ${(props) => `translate(${props.coord}px)`};
`;

const Player3 = styled.div`
  display: ${(props) =>
    props.count.current >= props.displayCount ? "block" : "none"};
${Player}
  transform: ${(props) => `rotateX(188deg) translate(${props.coord}px)`};
`;

const PitchBtnBox = styled.button`
  ${box};
  background-size: 300% 100%;

  border-radius: 50px;
  transition: all 0.4s ease-in-out;
  background-image: linear-gradient(
    to right,
    #fc6076,
    #ff9a44,
    #ef9d43,
    #e75516
  );
  box-shadow: 0 4px 15px 0 rgba(252, 104, 110, 0.75);
  &:hover {
    background-position: 100% 0;
    transition: all 0.4s ease-in-out;
  }
`;
export default PlayGround;
