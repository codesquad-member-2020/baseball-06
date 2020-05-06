import styled, { createGlobalStyle, css } from "styled-components";

export const GlobalStyle = createGlobalStyle`
    body{
  margin: 0 auto;
  width: 960px;
        background-color: #1B0C0A;
        text-align: center;
        /* opacity:0.8; */
    }
    h1{
        color:#fff;
    }
`;

export const Layout = css`
  display: flex;
  justify-content: center;
  align-items: center;

  /* margin: 0 auto; */
`;
