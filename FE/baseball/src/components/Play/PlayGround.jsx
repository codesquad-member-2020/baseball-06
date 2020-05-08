import React, { useRef, useState, useEffect } from "react";
import styled, { ThemeProvider } from "styled-components";
import theme from "../../styles/theme";
import ground from "../../styles/images/ground.jpg";
const img =
  "https://www.animatedimages.org/data/media/158/animated-baseball-image-0051.gif";

function PlayGround() {
  const playerRef = useRef();
  const [coord, setCoord] = useState(0);
  let x = 0;
  const onPitch = () => {
    if (x < -350) return;
    console.log(x);
    setCoord(x);
    x += -2;
    requestAnimationFrame(onPitch);
  };

  // useEffect(() => {
  //   playerRef.current = requestAnimationFrame(onPitch);
  // })[onPitch];
  console.log(coord);
  return (
    <GroundArea>
      <Ground>
        <Player ref={playerRef} coord={coord} />
        <PitchBtn onClick={onPitch}>Pitch</PitchBtn>
      </Ground>
    </GroundArea>
  );
}

const GroundArea = styled.div`
  position: relative;
  flex: 1;
`;

const Ground = styled.div`
  position: absolute;

  border: 1px solid red;
  width: 331px;
  /* height: 288px; */
  top: 354px;
  left: 715px;
  transform: rotate(-28deg);
`;

const Player = styled.div`
  position: absolute;

  width: 80px;
  height: 100px;
  background: no-repeat url(${img});
  transform: ${(props) => `rotateY(187deg) translateX(${props.coord}px)`};
`;

const PitchBtn = styled.button`
  height: 20px;
  width: 50px;
`;

export default PlayGround;
