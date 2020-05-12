import styled from "styled-components";

export const SideBox = styled.div`
  overflow: auto;
  padding: 20px;
  height: 100%;
  width: 300px;
  background-color: ${(props) => props.theme.backgroundColor};
  letter-spacing: 3.5px;
`;

export const SideBoxBtn = styled.button`
  width: 25px;
  height: 67px;

  border-radius: 10%;

  background-image: linear-gradient(
    to right,
    #ece9e6 0%,
    #ffffff 51%,
    #ece9e6 100%
  );
`;

export const SideBoxBtnText = styled.span`
  transform: rotate(-180deg);
  vertical-align: top;
  writing-mode: tb-rl;
  color: rgb(15, 46, 71);
  font-weight: 700;
  line-height: 1;
`;

export const SideBoxWrap = styled.div`
  display: flex;
  align-items: center;
  width: 320px;
  position: absolute;
  top: 0;
  right: -295px;
  height: 100%;
`;
