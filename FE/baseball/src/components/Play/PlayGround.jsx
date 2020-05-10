import React, { useRef, useState, useEffect, useCallback } from "react";
import styled, { ThemeProvider, css } from "styled-components";
import theme from "../../styles/theme";
import { GAME_RESULT_URL } from "../../constants/url";

const pticherImg =
  "https://ih0.redbubble.net/image.12303453.4706/sticker,375x360.png";
const ballImg =
  "https://www.animatedimages.org/data/media/158/animated-baseball-image-0086.gif";
const img = "http://ih2.redbubble.net/image.12303484.4729/sticker,375x360.png";

function PlayGround() {
  const initialBallTopCoord = 45;
  const initialBallLeftCoord = 55;

  const [batterCoord, setBatterCoord] = useState(385);

  const [ballTopCoord, setBallTopCoord] = useState(initialBallTopCoord);
  const [ballLeftCoord, setBallLeftCoord] = useState(initialBallLeftCoord);
  const [batterDisplay, setBatterDisplay] = useState(true);
  const [resultDisplay, setResultDisplay] = useState(true);
  const [pitchBtnDisplay, setPitchBtnDisplay] = useState("block");
  const [resultScale, setResultScale] = useState(false);
  const [result, setResult] = useState("");
  const batterCoordCount = useRef(0);
  const ballCoord = useRef(0);
  const count = useRef(3);
  const batter = useRef();
  const scoredBatter = useRef();
  const onPitch = useCallback(() => {
    pitchAnimation();
  });

  const pitchAnimation = () => {
    let ballRaf = null;
    const initBallCoord = 120;
    showResult();

    const hitBallCoord = 100;
    if (ballCoord.current > hitBallCoord) {
      hitBall();
    }
    if (ballCoord.current > initBallCoord) {
      return initBall(ballRaf);
    }

    moveBall();
    ballRaf = requestAnimationFrame(pitchAnimation);
  };

  const moveBall = () => {
    const ballSpeed = 5;
    const ballLeftSpped = 2.5;

    ballCoord.current += ballSpeed;
    setBallTopCoord((prevState) => prevState + ballSpeed);
    setBallLeftCoord((prevState) => prevState - ballLeftSpped);
  };

  const hitBall = () => {
    batter.current.style.transform = "rotateY(140deg)";
    setTimeout(() => (batter.current.style.transform = "rotateY(0deg)"), 100);
  };

  const initBall = (ballRaf) => {
    ballCoord.current = 0;
    setBallTopCoord(initialBallTopCoord);
    setBallLeftCoord(initialBallLeftCoord);
    cancelAnimationFrame(ballRaf);
    return fetchResult();
  };

  const fetchResult = () => {
    fetch(GAME_RESULT_URL)
      .then((res) => res.json())
      .then((data) => {
        const result = data.body.battingResult;
        setResult(result + "!!");
        showPitchBtn();
        if (result === "HIT" || result === "END") {
          count.current++;
          replaceBatter();
          moveBatter();
        } else if (result === "OUT") {
          replaceBatter();
        }
      });
  };

  useEffect(() => {
    let timeout = null;
    if (count.current >= 4) {
      scoredBatter.current.style.display = "block";
      timeout = setTimeout(() => {
        scoredBatter.current.style.display = "none";
      }, 1000);

      setResult((prevState) => `${prevState} 1득점🥰`);
      debugger;
      setResultScale(true);
      setTimeout(() => setResultScale(false), 1500);
    }
    return () => {
      clearTimeout(timeout);
    };
  }, [count.current]);

  const showResult = () => {
    setPitchBtnDisplay("none");
    setResultDisplay("block");
    setResult("기다려😛");
  };

  const showPitchBtn = () => {
    setTimeout(() => {
      setPitchBtnDisplay("block");
      setResultDisplay("none");
    }, 1000);
  };

  const replaceBatter = () => {
    setBatterDisplay(false);
    setTimeout(() => setBatterDisplay(true), 1000);
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
        <ResultBox display={resultDisplay} resultScale={resultScale}>
          {result}
        </ResultBox>
        <PitcherArea>
          <Pitcher></Pitcher>
          <Ball ballTopCoord={ballTopCoord} ballLeftCoord={ballLeftCoord} />
        </PitcherArea>
        <Ground top={65} left={43} deg={-28}>
          <Batter1
            ref={batter}
            coord={batterCoord}
            count={count}
            batterDisplay={batterDisplay}
          />
        </Ground>
        <Ground top={65} left={43} deg={-28}>
          <Batter2 coord={batterCoord} count={count} displayCount={1} />
        </Ground>
        <Ground top={31} left={50} deg={-162}>
          <Batter3 coord={batterCoord} count={count} displayCount={2} />
        </Ground>
        <Ground top={29} left={28} deg={-201}>
          <Batter3 coord={batterCoord} count={count} displayCount={3} />
        </Ground>
        <Ground top={60} left={27} deg={30}>
          <Batter2
            coord={batterCoord}
            count={count}
            displayCount={4}
            ref={scoredBatter}
          />
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
  min-width: 263px;
  height: 70px;
  display: ${(props) => (props.display === "block" ? "block" : "none")};
  text-align: center;
  font-size: 40px;
  color: ${(props) => props.theme.mainFontColor};
`;

const ResultBox = styled.div`
  ${box};
  background-color: ${(props) => props.theme.backgroundColor};
  transition: all 0.4s ease-in-out;
  transform: ${(props) => props.resultScale && "scale(1.8)"};
  z-index: ${(props) => props.resultScale && "1"};
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

const Batter = css`
  width: 80px;
  height: 100px;
  background: no-repeat url(${img});
  background-position: center;
  background-size: cover;
`;

const Batter1 = styled.div`
  display: ${(props) => (props.batterDisplay ? "block" : "none")};
  ${Batter}
`;

const Batter2 = styled.div`
  display: ${(props) => {
    return props.count.current >= props.displayCount ? "block" : "none";
  }};
 ${Batter}

  transform: ${(props) => `translate(${props.coord}px)`};
`;

const Batter3 = styled.div`
  display: ${(props) =>
    props.count.current >= props.displayCount ? "block" : "none"};
${Batter}
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