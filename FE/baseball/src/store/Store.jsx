import React, { createContext, useReducer, useEffect, useMemo } from "react";
// import Reducer from "./reducer.js";
import { mock } from "../mock/mock";
import { INNING_INFO_URL } from "../constants/url";
import fetchData from "../useFetch";

export const SET_INNING_INFO = "SET_INNING_INFO ";

const initialState = {
  score: { Home: 0, Away: 0 },
  inningStatus: {},
  inningRound: {},
  updatedPlayer: [],
  updatedBaseman: {},
  inningScore: [],
  isFetching: false,
};

//분리하기

const reducer = (state, { type, payload }) => {
  switch (type) {
    case SET_INNING_INFO:
      const score = mock.updatedBaseman.updatedScore;
      const updatedPlayer = mock.updatedBaseman.updatedPlayer;
      const updatedBaseman = mock.updatedBaseman.updatedBaseman;
      const inningStatus = payload.inningStatus;
      const inningRound = payload.earlyInningList[0];
      const inningScore = payload.earlyInningList;
      console.log(inningRound, 11111);
      return {
        ...state,
        score,
        inningStatus,
        inningRound,
        updatedPlayer,
        updatedBaseman,
        inningScore,
      };
  }
};

const Store = ({ children }) => {
  const [state, dispatch] = useReducer(reducer, initialState);

  const setInningInfo = (inningData) => {
    dispatch({ type: SET_INNING_INFO, payload: inningData });
  };

  useEffect(() => {
    fetchData(setInningInfo, INNING_INFO_URL);
  }, []);

  const value = useMemo(
    () => ({
      score: state.score,
      inningStatus: state.inningStatus,
      updatedPlayer: state.updatedPlayer,
      updatedBaseman: state.updatedBaseman,
      setInningInfo: state.setInningInfo,
      inningRound: state.inningRound,
      inningScore: state.inningScore,
      setInningInfo,
      dispatch,
    }),
    [
      state.score,
      state.inningStatus,
      state.updatedPlayer,
      state.updatedBaseman,
      state.inningRound,
      state.inningScore,
    ]
  );

  return (
    <BaseballContext.Provider value={value}>
      {children}
    </BaseballContext.Provider>
  );
};

export const BaseballContext = createContext(initialState);
export default Store;
