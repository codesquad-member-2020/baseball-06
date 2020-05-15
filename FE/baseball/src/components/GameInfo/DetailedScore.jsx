import React, {
  createContext,
  useContext,
  useReducer,
  useMemo,
  useState,
} from "react";
import styled, { ThemeProvider } from "styled-components";
import { Player } from "../../styles/global";
import DetailedScoreTd from "./DetailedScoreTd";
import { BaseballContext } from "../../store/Store";

const ballImg =
  "https://www.animatedimages.org/data/media/158/animated-baseball-image-0086.gif";

export const BaseBallContext = createContext();

function DetailedScore() {
  const { selectedTeamInfo } = useContext(BaseballContext);
  const { offenseTeamName, defenseTeamName } = selectedTeamInfo;

  const ROUND_LENGTH = 12;
  const TOTAL_SCORE = "R";

  const getLastTh = (i) => {
    return (
      <th key={i} scope="col">
        {TOTAL_SCORE}
      </th>
    );
  };

  const getThList = () => {
    return Array(ROUND_LENGTH + 1)
      .fill()
      .map((_, i) => {
        if (i >= ROUND_LENGTH) return getLastTh(i);
        return (
          <th key={i} scope="col">
            {i + 1}
          </th>
        );
      });
  };

  return (
    <DetailedScoreTable>
      <thead>
        <tr>
          <th scope="col"></th>
          <th scope="col"></th>
          {getThList()}
        </tr>
      </thead>

      <tbody>
        <tr>
          <th scope="row" className={"game-turn"}>
            <MyTeam src={ballImg} alt="나의 팀" visibility={"hidden"} />
          </th>
          <th scope="row">
            <TeamName>{offenseTeamName}</TeamName>
            <Turn>
              <Player visibility={"hidden"}>player</Player>
            </Turn>
          </th>

          <DetailedScoreTd roundLength={ROUND_LENGTH} />
        </tr>
        <tr>
          <th scope="row" className={"game-turn"}>
            <MyTeam src={ballImg} alt="나의 팀" />
          </th>
          <th scope="row">
            <TeamName>{defenseTeamName}</TeamName>
            <Turn>
              <Player>player</Player>
            </Turn>
          </th>
          <DetailedScoreTd roundLength={ROUND_LENGTH} />
        </tr>
      </tbody>
    </DetailedScoreTable>
  );
}

const DetailedScoreTable = styled.table`
  margin: 100px auto;
  width: 950px;
  height: 250px;
  border: 1px solid ${(props) => props.theme.subPinkColor};

  & td,
  tr,
  th {
    width: 44px;
    color: ${(props) => props.theme.mainFontColor};
    vertical-align: middle;
    font-size: 25px;
    background: #111;
  }

  & thead tr {
    height: 70px;
  }
  & thead th {
    border-bottom: 3px solid ${(props) => props.theme.subPinkColor};
  }
  & tbody th {
    width: 180px;
    padding: 18px 15px 0 0;
  }
  & .game-turn {
    width: 45px;
    padding: 5px;
  }
  & .total-score {
    color: ${(props) => props.theme.highlightColor};
  }
`;

const Turn = styled.span`
  padding-right: 13px;
`;

const TeamName = styled.div`
  color: ${(props) => props.theme.mainFontColor};
  vertical-align: bottom;
`;

const MyTeam = styled.img`
  width: 38px;
  height: 33px;
  padding-left: 10px;
  visibility: ${(props) => {
    if (props.visibility === "hidden") return "hidden";
  }};
`;

export default DetailedScore;
