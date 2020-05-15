import React, { createContext, useReducer, useEffect, useMemo } from "react";
// import Reducer from "./reducer.js";
import { mock } from "../mock/mock";
import { gameSelectionMock } from "../mock/gameSelectionMock";
import { INNING_INFO_URL } from "../constants/url";
import fetchData from "../useFetch";
import {
  teamInningInfoKey,
  teamInfoListKey,
  inningStatusKey,
} from "../constants/dataKey";

export const SET_INNING_INFO = "SET_INNING_INFO ";
export const SET_TEAM_NAME = "SET_TEAM_NAME";

const initialState = {
  score: { Home: 0, Away: 0 },
  inningStatus: {},
  inningRound: {},
  updatedPlayer: [],
  updatedBaseman: {},
  inningScore: [],
  selectedTeamInfo: {},
  teamName: {},
};

//분리하기

const { score } = teamInningInfoKey;

const getTotalScore = (dataList) => {
  const totalScore = dataList.reduce(
    (acc, data) => acc + data[teamInningInfoKey[score]],
    0
  );
  return totalScore;
};

const reducer = (state, { type, payload }) => {
  console.log(payload);

  switch (type) {
    case SET_INNING_INFO: {
      const score = mock.updatedBaseman.updatedScore;
      const updatedPlayer = mock.updatedBaseman.updatedPlayer;
      const updatedBaseman = mock.updatedBaseman.updatedBaseman;
      const inningStatus = payload.inningStatus;
      const inningRound = payload.earlyInningList[0];
      const inningScore = payload.earlyInningList;
      const totalScore = getTotalScore(inningScore);

      return {
        ...state,
        score,
        inningStatus,
        inningRound,
        updatedPlayer,
        updatedBaseman,
        inningScore,
        totalScore,
      };
    }

    case SET_TEAM_NAME: {
      const { defenseTeamName, offenseTeamName, teamType, pathname } = payload;

      console.log(payload, 12);
      return {
        ...state,
        selectedTeamInfo: {
          teamType,
          defenseTeamName,
          offenseTeamName,
          pathname,
        },
      };
    }
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
      inningRound: state.inningRound,
      inningScore: state.inningScore,
      selectedTeamInfo: state.selectedTeamInfo,
      totalScore: state.totalScore,
      setInningInfo,
      dispatch,
    }),
    [
      state.score,
      state.inningStatus,
      state.updatedPlayer,
      state.inningRound,
      state.inningScore,
      state.selectedTeamInfo,
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
