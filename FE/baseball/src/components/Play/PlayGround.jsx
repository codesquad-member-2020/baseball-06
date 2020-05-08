import React from "react";
import styled, { ThemeProvider } from "styled-components";
import theme from "../../styles/theme";
import ground from "../../styles/images/ground.jpg";

function PlayGround() {
  return (
    <Ground>
      <GroundImg></GroundImg>
    </Ground>
  );
}

const Ground = styled.div`
  position: absolute;
  top: 200px;
  opacity: 0.7;
  left: 0px;
  justify-content: center;
  width: 100%;
  height: 500px;
`;

const GroundImg = styled.div`
  /* background-image: url(${ground}); */
  background-position: center;
  background-repeat: no-repeat;
  background-size: cover;
  width: 100%;
  height: 100%;
`;

export default PlayGround;
