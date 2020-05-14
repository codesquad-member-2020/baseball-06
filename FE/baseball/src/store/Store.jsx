import React, { createContext, useReducer, useEffect, useMemo } from "react";
// import Reducer from "./reducer.js";
import { mock } from "../mock/mock";
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
};

//분리하기

// const { score } = teamInningInfoKey;

const getTotalScore = (dataList) => {
  const totalScore = dataList.reduce(
    (acc, data) => acc + data[teamInningInfoKey.score],
    0
  );
  return totalScore;
};

const reducer = (state, { type, teamType, payload }) => {
  console.log(type);

  switch (type) {
    case SET_INNING_INFO: {
      const score = mock.updatedBaseman.updatedScore;
      const updatedPlayer = mock.updatedBaseman.updatedPlayer;
      const updatedBaseman = mock.updatedBaseman.updatedBaseman;
      const inningStatus = payload.inningStatus;
      const inningRound = payload.earlyInningList[0];
      const inningScore = payload.earlyInningList;

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

    case SET_TEAM_NAME: {
      const { defenseTeamName, offenseTeamName } = payload;

      console.log(teamType, defenseTeamName, offenseTeamName);
      return {
        ...state,
        selectedTeamInfo: {
          teamType,
          defenseTeamName,
          offenseTeamName,
        },
      };
    }
  }
};

const Store = ({ children }) => {
  const [state, dispatch] = useReducer(reducer, initialState);
  console.log(state.selectedTeamInfo);

  const setInningInfo = (inningData) => {
    dispatch({ type: SET_INNING_INFO, payload: inningData });
  };

  const setTeamName = (teamType, nameData) => {
    dispatch({ type: SET_TEAM_NAME, teamType, payload: nameData });
  };

  useEffect(() => {
    fetchData(setInningInfo, INNING_INFO_URL);
  }, []);

  const value = useMemo(
    () => ({
      score: state.score,
      inningStatus: state.inningStatus,
      updatedPlayer: state.updatedPlayer,
      //   setInningInfo: state.setInningInfo,
      inningRound: state.inningRound,
      inningScore: state.inningScore,
      selectedTeamInfo: state.selectedTeamInfo,
      // teamType: state.teamType,
      // defenseTeamName: state.defenseTeamName,
      // offenseTeamName: state.offenseTeamName,
      setInningInfo,
      setTeamName,
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
  console.log(value);
  return (
    <BaseballContext.Provider value={value}>
      {children}
    </BaseballContext.Provider>
  );
};

export const BaseballContext = createContext(initialState);
export default Store;
