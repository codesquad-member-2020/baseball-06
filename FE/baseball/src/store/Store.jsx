import React, { createContext, useReducer } from "react";
import Reducer from "./reducer.js";

const initialState = {
  score: { Home: 0, Away: 0 },
  inningStatus: {},
  inningRound: {},
  updatedPlayer: [],
  updatedBaseman: {},
  inningScore: [],
  isFetching: false,
};

const reducer = (state, { type, payload }) => {
  switch (type) {
    case SET_INNING_INFO:
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
};

const Store = ({ children }) => {
  const [state, dispatch] = useReducer(Reducer, initialState);

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

  return <Context.Provider value={value}>{children}</Context.Provider>;
};

export const Context = createContext(initialState);
export default Store;
