import React, { useRef, useState, useEffect } from "react";
import styled, { ThemeProvider } from "styled-components";
import theme from "../../styles/theme";
import ground from "../../styles/images/ground.jpg";

const pticherImg =
  "https://ih0.redbubble.net/image.12303453.4706/sticker,375x360.png";
const ballImg =
  "https://www.animatedimages.org/data/media/158/animated-baseball-image-0086.gif";
const img = "http://ih2.redbubble.net/image.12303484.4729/sticker,375x360.png";
// const img = "https://ontherun.netlify.app/static/media/runner.c141cee0.gif";
// const img =
// "https://images-wixmp-ed30a86b8c4ca887773594c2.wixmp.com/f/bff79450-9f9c-4baf-af12-b6289ab026d8/d5xpfor-f6658e45-58a4-44e4-b204-431b39285355.gif?token=eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1cm46YXBwOiIsImlzcyI6InVybjphcHA6Iiwib2JqIjpbW3sicGF0aCI6IlwvZlwvYmZmNzk0NTAtOWY5Yy00YmFmLWFmMTItYjYyODlhYjAyNmQ4XC9kNXhwZm9yLWY2NjU4ZTQ1LTU4YTQtNDRlNC1iMjA0LTQzMWIzOTI4NTM1NS5naWYifV1dLCJhdWQiOlsidXJuOnNlcnZpY2U6ZmlsZS5kb3dubG9hZCJdfQ.U3JxM9boQ07PxcmUJEqYcM8zqJ_u1TmDaZ_yC8Nku-0";
// const img =
// "https://www.animatedimages.org/data/media/158/animated-baseball-image-0051.gif";

function PlayGround() {
  const playerRef = useRef();
  const [coord, setCoord] = useState(0);
  // const [count, setCount] = useState(0);
  const [rotation, setRotation] = useState(187);
  const [top, setTop] = useState(65);
  const [left, setLeft] = useState(43);
  const [deg, setDeg] = useState(-28);
  const [ballTopCoord, setBallTopCoord] = useState(45);
  const [ballLeftCoord, setBallLeftCoord] = useState(55);
  const [hitterDisplay, setHitterDisplay] = useState(true);
  const x = useRef(0);
  const ballCoord = useRef(0);
  const count = useRef(0);
  const rafId = useRef();
  const rafBall = useRef(0);
  const onPitch = () => {
    // animation();
    pitchAnimation();

    //fetch 해온뒤 결과가 스트라이크면 count를 올리지 않는다
  };

  const pitchAnimation = () => {
    if (ballCoord.current > 175) {
      ballCoord.current = 0;
      setBallTopCoord(45);
      setBallLeftCoord(55);
      fetch("http://15.164.101.161:8080/dev/dotest")
        .then((res) => res.json())
        .then((data) => {
          console.log(data.body.battingResult);
          if (data.body.battingResult === "HIT") {
            count.current++;
            setHitterDisplay(false);
            setTimeout(() => setHitterDisplay(true), 2000);
            animation();
          }
        });

      return;
    }
    ballCoord.current += 3;
    setBallTopCoord((prevState) => prevState + 3);
    setBallLeftCoord((prevState) => prevState - 1);
    rafBall.current = requestAnimationFrame(pitchAnimation);
  };

  const animation = () => {
    if (x.current > 385) {
      x.current = 0;
      return cancelAnimationFrame(rafId.current);
    }
    setCoord(x.current);

    x.current += 10;
    rafId.current = requestAnimationFrame(animation);
  };

  return (
    <GroundArea>
      <PitcherArea>
        <Pitcher></Pitcher>
        <Ball ballTopCoord={ballTopCoord} ballLeftCoord={ballLeftCoord} />
      </PitcherArea>
      <Ground top={top} left={left} deg={deg}>
        <Player
          rotation={rotation}
          coord={coord}
          count={count}
          hitterDisplay={hitterDisplay}
        />
      </Ground>
      <Ground1 top={top} left={left} deg={deg}>
        <Player1 rotation={rotation} coord={coord} count={count} />
      </Ground1>
      <Ground2>
        <Player2 rotation={rotation} coord={coord} count={count} />
      </Ground2>
      <Ground3>
        <Player3 rotation={rotation} coord={coord} count={count} />
      </Ground3>
      <Ground4>
        <Player4 rotation={rotation} coord={coord} count={count} />
      </Ground4>
      <PitchBtn onClick={onPitch}>Pitch</PitchBtn>
    </GroundArea>
  );
}

const GroundArea = styled.div`
  position: relative;
  flex: 1;
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

  /* border: 1px solid red; */

  width: 397px;

  top: ${(props) => props.top + "%"};
  left: ${(props) => props.left + "%"};
  transform: ${(props) => `rotate(${props.deg}deg)`};
`;
const Ground1 = styled.div`
  position: absolute;

  /* border: 1px solid red; */

  width: 397px;

  top: ${(props) => props.top + "%"};
  left: ${(props) => props.left + "%"};
  transform: ${(props) => `rotate(${props.deg}deg)`};
`;
const Ground2 = styled.div`
  position: absolute;

  width: 397px;

  top: 31%;
  left: 50%;
  transform: rotate(-162deg);
`;
const Ground3 = styled.div`
  position: absolute;

  width: 397px;

  top: 29%;
  left: 28%;
  transform: rotate(-201deg);
`;
const Ground4 = styled.div`
  position: absolute;

  width: 397px;

  top: 60%;
  left: 27%;
  transform: rotate(30deg);
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

const Player = styled.div`

display: ${(props) => {
  console.log(props.hitterDisplay);
  return props.hitterDisplay ? "block" : "none";
}};

  width: 80px;
  height: 100px;

  background: no-repeat url(${img});
  background-position: center;
  background-size: cover;
  /* transform: ${(props) => `translate(${props.coord}px)`}; */
`;
const Player1 = styled.div`
  display: ${(props) => {
    return props.count.current >= 1 ? "block" : "none";
  }};

  width: 80px;
  height: 100px;

  background: no-repeat url(${img});
  background-position: center;
  background-size: cover;
  transform: ${(props) => `translate(${props.coord}px)`};
`;
const Player2 = styled.div`
  display: ${(props) => (props.count.current >= 2 ? "block" : "none")};

  width: 80px;
  height: 100px;
  background: no-repeat url(${img});
  background-position: center;
  background-size: cover;

  transform: ${(props) => `rotateX(188deg) translate(${props.coord}px)`};
`;
const Player3 = styled.div`
  display: ${(props) => (props.count.current >= 3 ? "block" : "none")};

  width: 80px;
  height: 100px;
  background: no-repeat url(${img});
  background-position: center;
  background-size: cover;

  transform: ${(props) => `rotateX(188deg) translate(${props.coord}px)`};
`;
const Player4 = styled.div`
  display: ${(props) => {
    return props.count.current === 4 ? "block" : "none";
  }};

  width: 80px;
  height: 100px;

  background: no-repeat url(${img});
  background-position: center;
  background-size: cover;
  transform: ${(props) => `translate(${props.coord}px)`};
`;

const PitchBtn = styled.button`
  height: 20px;
  width: 50px;
`;

export default PlayGround;
