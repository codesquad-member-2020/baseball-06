import React, { createContext, useReducer, useMemo, useEffect } from "react";
import styled, { ThemeProvider } from "styled-components";
import theme from "../../styles/theme";
import PlayGround from "./PlayGround";
import Header from "../Header/Header";
import { mock } from "../../mock";
import GameLog from "./GameLog";
import {INNING_INFO_URL} from '../../constants/url'
import fetchData from '../../useFetch'

import { GlobalStyle, Background } from "../../styles/global";

export const SET_INNING_INFO = 'SET_INNING_INFO ';


export const BaseBallContext = createContext(); 



const initialState = {
  score: { Home: 0, Away: 0 },
  inningStatus: {},
  inningRound : {},
  updatedPlayer: [],
  updatedBaseman: {},
  isFetching: false,
}; // 초기 데이터 fetch해와서 여기에 값 넣어줌

const reducer = (state, {type, payload}) => {
  switch (type) {
    case SET_INNING_INFO:
      const score = mock.updatedBaseman.updatedScore;
      const updatedPlayer = mock.updatedBaseman.updatedPlayer;
      const updatedBaseman = mock.updatedBaseman.updatedBaseman;
      const inningStatus = payload.inningStatus;
      const inningRound = payload.earlyInningList[0]
   return {
        ...state,
        score,
        inningStatus,
        inningRound,
        updatedPlayer,
        updatedBaseman,
      };
  }
}


function Defense() {
  const [state, dispatch] = useReducer(reducer, initialState);

  const setInningInfo = (inningData) => {
    dispatch({type:SET_INNING_INFO , payload : inningData})
  }

  useEffect(() => {
  fetchData(setInningInfo,INNING_INFO_URL);
}, []);


  const value = useMemo(
    () => ({
      score: state.score,
      inningStatus: state.inningStatus,
      updatedPlayer: state.updatedPlayer,
      updatedBaseman: state.updatedBaseman,
      setInningInfo: state.setInningInfo,
      inningRound: state.inningRound,
      setInningInfo,
      dispatch,
    }),
    [state.score, state.inningStatus, state.updatedPlayer, state.updatedBaseman,state.inningRound]
  );

  return (
    <BaseBallContext.Provider value={value}>
      <ThemeProvider theme={theme}>
        <GlobalStyle />
        <Background>
          <Header />
          <PlayGround></PlayGround>
        </Background>
      </ThemeProvider>
    </BaseBallContext.Provider>
  );
}

export default Defense;
