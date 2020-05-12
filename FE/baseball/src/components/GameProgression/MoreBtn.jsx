import React, { useCallback } from "react";
import styled, { css } from "styled-components";

function MoreButton({
  wrap,
  box,
  logBtnText,
  setLogBtnText,
  OPEN_BTN_TEXT,
  CLOSE_BTN_TEXT,
}) {
  const TRANSITION_PROPERTY = "all .3s ease-in-out";

  const openLog = useCallback(() => {
    console.log(wrap);
    wrap.style.transition = TRANSITION_PROPERTY;

    const logBoxWidth = box.offsetWidth;
    if (logBtnText === OPEN_BTN_TEXT) {
      setLogBtnText(CLOSE_BTN_TEXT);
      addTranslate(`-${logBoxWidth}`);
    } else {
      setLogBtnText(OPEN_BTN_TEXT);
      addTranslate(0);
    }
  }, [logBtnText]);

  const addTranslate = (distance) => {
    return (wrap.style.transform = `translateX(${distance}px)`);
  };

  return (
    <MoreBtn onClick={openLog}>
      <MoreBtnText>{logBtnText}</MoreBtnText>
    </MoreBtn>
  );
}

const MoreBtn = styled.button`
  width: 67px;
  height: 30px;
  border-radius: 5px;
  background-color: #ece9e6;
  margin-right: 80px;
`;

const MoreBtnText = styled.button`
  color: rgb(15, 46, 71);
  font-weight: 700;
  line-height: 1;
`;

export default MoreButton;
