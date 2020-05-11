import styled, { createGlobalStyle, css } from "styled-components";
import img from "../styles/images/ground.jpg";

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
  min-width: 1536px;
  min-height: 550px;
  background-image: url(${img});
  background-position: center;
  background-repeat: no-repeat;
  background-size: cover;
  height: 100vh;
  width: 100vw;
  display: flex;
  flex-direction: column;
`;
export const BackgroundImg = styled.div`
  background-color: rgba(0, 0, 0, 0.6);
  height: 100%;
  width: 100%;
`;

export const Layout = css`
  display: flex;
  justify-content: center;
  align-items: center;
`;
