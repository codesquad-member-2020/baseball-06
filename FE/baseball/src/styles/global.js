import styled, { createGlobalStyle, css } from "styled-components";
import img from "../styles/images/ground.jpg";
// import img from "../styles/images/baseball.jpg";

export const GlobalStyle = createGlobalStyle`
    body{
         margin: 0 auto;
    
        text-align: center;
        font-weight:bold;
        color:#fff;
    }
    h1{
        color:#fff;
    }
`;

export const Background = styled.div`
  background-image: url(${img});
  background-position: center;
  background-repeat: no-repeat;
  background-size: cover;
  height: 100vh;
  width: 100vw;
`;
export const BackgroundImg = styled.div`
  /* background-color: #000; */
  background-color: rgba(0, 0, 0, 0.6);

  height: 100%;
  width: 100%;
`;

export const Layout = css`
  display: flex;
  justify-content: center;
  align-items: center;
`;
