import styled, { createGlobalStyle, css } from "styled-components";

export const GlobalStyle = createGlobalStyle`
    body{
  margin: 0 auto;
  width: 960px;
        background-color: #060405;
        text-align: center;
        opacity: 0.9;
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
