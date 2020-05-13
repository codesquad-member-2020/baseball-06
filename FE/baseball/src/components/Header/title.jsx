import React from "react";
import styled from "styled-components";

function Title({ type, titleText }) {
  // const title = "BASEBALL GAME ONLINE";

  return (
    <>
      <TitleArea type={type}>{titleText}</TitleArea>
    </>
  );
}

const TitleArea = styled.h1`
  padding: 25px 0 10px;
  font-weight: bold;
  font-size: ${(props) => (props.type === "sub" ? "30px" : "40px")};
  background-color: ${(props) => {
    if (props.type === "sub") return props.theme.backgroundColor;
  }};
`;

export default Title;
