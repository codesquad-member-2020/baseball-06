import React, { createContext, useReducer, useMemo } from "react";
import styled, { ThemeProvider } from "styled-components";
import { Player } from "../../styles/global";
const ballImg =
  "https://www.animatedimages.org/data/media/158/animated-baseball-image-0086.gif";

function DetailedScore() {
  const roundLength = 12;

  const getLastTh = (i) => {
    if (i >= roundLength)
      return (
        <th key={i} scope="col">
          {"R"}
        </th>
      );
  };

  const getThArray = () => {
    return Array(roundLength + 1)
      .fill()
      .map((_, i) => {
        getLastTh(i);
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
          {getThArray()}
        </tr>
      </thead>

      <tbody>
        <tr>
          <th scope="row" className={"game-turn"}>
            <MyTeam src={ballImg} alt="나의 팀" visibility={"hidden"} />
          </th>
          <th scope="row">
            <TeamName>away team</TeamName>
            <Turn>
              <Player visibility={"hidden"}>player</Player>
            </Turn>
          </th>
          <td>1</td>
          <td>2</td>
          <td>5</td>
          <td>6</td>
          <td>4</td>
          <td>1</td>
          <td>2</td>
          <td></td>
          <td></td>
          <td></td>
          <td></td>
          <td></td>
          <td className={"total-score"}>8</td>
        </tr>
        <tr>
          <th scope="row" className={"game-turn"}>
            <MyTeam src={ballImg} alt="나의 팀" />
          </th>
          <th scope="row">
            <TeamName>home team</TeamName>
            <Turn>
              <Player>player</Player>
            </Turn>
          </th>
          <td>0</td>
          <td>2</td>
          <td>5</td>
          <td>6</td>
          <td>7</td>
          <td>0</td>
          <td>2</td>
          <td></td>
          <td></td>
          <td></td>
          <td></td>
          <td></td>
          <td className={"total-score"}>5</td>
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
