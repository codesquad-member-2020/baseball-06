import styled, { createGlobalStyle, css } from "styled-components";
import img from "../styles/images/baseball.jpg";

export const GlobalStyle = createGlobalStyle`
    body{
         margin: 0 auto;
        background-image: url(${img});
        background-position: center;
        background-repeat: no-repeat;
        background-size: cover;
        text-align: center;
        font-weight:bold;
        color:#fff;
    }
    h1{
        color:#fff;
    }
`;

export const Background = styled.div`
  background-color: #000;
  background-color: rgba(0, 0, 0, 0.7);
  height: 100vh;
  width: 100vw;
`;

export const Layout = css`
  display: flex;
  justify-content: center;
  align-items: center;
`;
