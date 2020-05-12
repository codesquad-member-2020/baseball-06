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
  overflow: hidden;
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

export const Scroll = css`
  ::-webkit-scrollbar-track {
    border-radius: 10px;

    background-color: #cccccc;
  }

  ::-webkit-scrollbar {
    width: 12px;
    border-radius: 10px;
    background-color: #f5f5f5;
  }

  ::-webkit-scrollbar-thumb {
    border-radius: 10px;

    background-image: -webkit-linear-gradient(
      90deg,
      rgba(0, 0, 0, 1) 0%,
      rgba(0, 0, 0, 1) 25%,
      transparent 100%,
      rgba(0, 0, 0, 1) 75%,
      transparent
    );

    background-color: #555;
  }
`;

export const MoreBtn = css`
  width: 67px;
  height: 25px;
  border-radius: 5px;
  background-color: #ece9e6;
`;
