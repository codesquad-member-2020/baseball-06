import React from "react";
import styled from "styled-components";

function Title() {
  const title = "BASEBALL GAME ONLINE";

  return (
    <>
      <TitleArea>{title}</TitleArea>
    </>
  );
}

const TitleArea = styled.h1`
  padding: 30px;
  font-weight: bold;
  font-size: 40px;
`;

export default Title;
