import React, { useRef, useState, useEffect } from "react";
import styled, { ThemeProvider } from "styled-components";
import theme from "../../styles/theme";
import ground from "../../styles/images/ground.jpg";
const ball =
  "https://www.animatedimages.org/data/media/158/animated-baseball-image-0086.gif";
// const img =
// "https://media.tenor.com/images/2fde593779f6da7fc3a6ee2ce6f3f019/tenor.gif";
const img = "http://ih2.redbubble.net/image.12303484.4729/sticker,375x360.png";
// const img =
// "https://www.animatedimages.org/data/media/158/animated-baseball-image-0051.gif";

function PlayGround() {
  const playerRef = useRef();
  const [coord, setCoord] = useState(0);
  // const [count, setCount] = useState(0);
  const [rotation, setRotation] = useState(187);
  const [top, setTop] = useState(62);
  const [left, setLeft] = useState(46);
  const [deg, setDeg] = useState(-30);
  const x = useRef(0);
  const count = useRef(0);
  const rafId = useRef();
  const onPitch = () => {
    animation();
    count.current++;
  };

  const animation = () => {
    console.log(x.current);
    if (x.current > 360) return;
    setCoord(x.current);
    x.current += 10;
    rafId.current = requestAnimationFrame(animation);
  };

  useEffect(() => {
    if (x.current < -350) {
      // setCoord(0);
      // x.current = 0;
      // setRotation(350);
      // setTop(24);
      // setLeft(43);
      // setDeg(-156);
    }
    return () => {
      if (x.current > 360) {
        x.current = 0;
        cancelAnimationFrame(rafId.current);
      }
    };
  }, [coord]);
  console.log(coord);
  return (
    <GroundArea>
      <Ground top={top} left={left} deg={deg}>
        <Player rotation={rotation} coord={coord} count={count} />
      </Ground>
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

const Ground = styled.div`
  position: absolute;

  /* border: 1px solid red; */

  width: 397px;

  top: ${(props) => props.top + "%"};
  left: ${(props) => props.left + "%"};
  transform: ${(props) => `rotate(${props.deg}deg)`};
`;
const Ground2 = styled.div`
  position: absolute;

  border: 1px solid red;

  width: 397px;

  top: 31%;
  left: 50%;
  transform: rotate(-162deg);
`;
const Ground3 = styled.div`
  position: absolute;

  border: 1px solid red;

  width: 397px;

  top: 31%;
  left: 25%;
  transform: rotate(-201deg);
`;
const Ground4 = styled.div`
  position: absolute;

  border: 1px solid red;

  width: 397px;

  top: 60%;
  left: 27%;
  transform: rotate(30deg);
`;

const Player = styled.div`
  display: ${(props) => {
    return props.count.current === 1 ? "block" : "none";
  }};

  width: 80px;
  height: 100px;

  background: no-repeat url(${img});
  background-position: center;
  background-size: cover;
  transform: ${(props) => `translate(${props.coord}px)`};
`;
const Player2 = styled.div`
  display: ${(props) => (props.count.current === 2 ? "block" : "none")};

  width: 80px;
  height: 100px;
  background: no-repeat url(${img});
  background-position: center;
  background-size: cover;

  transform: ${(props) => `rotateX(188deg) translate(${props.coord}px)`};
`;
const Player3 = styled.div`
  display: ${(props) => (props.count.current === 3 ? "block" : "none")};

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
