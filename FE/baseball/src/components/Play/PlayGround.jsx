import React from "react";
import styled, { ThemeProvider } from "styled-components";
import theme from "../../styles/theme";
import ground from "../../styles/images/ground.jpg";
const img =
  "https://www.animatedimages.org/data/media/158/animated-baseball-image-0051.gif";

function PlayGround() {
  return (
    <Ground>
      <Player></Player>
    </Ground>
  );
}

const Ground = styled.div`
  /* position: absolute; */
  /* top: 200px; */
  /* opacity: 0.7; */
  /* left: 0px; */
  /* justify-content: center; */
  /* width: 100%; */
  /* height: 500px; */
`;

const Player = styled.div`
  position: absolute;

  width: 100px;
  height: 100px;

  background: no-repeat url(${img});
`;

export default PlayGround;
