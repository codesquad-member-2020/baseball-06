import React from "react";
import styled, { ThemeProvider } from "styled-components";
import theme from "../../styles/theme";

function PlayerInfo({ updatedPlayer }) {
  const templatePitcher = ({ pitches }) => {
    return <Player>#{pitches}</Player>;
  };

  const templateBatter = ({ bat, hit }) => {
    return (
      <>
        <Player>{bat}타석</Player>
        <Player>{hit}안타</Player>
      </>
    );
  };

  return (
    <PlayerInfoWrap>
      {updatedPlayer.map((player) => {
        return (
          <div>
            <div>
              <PlayerType>
                {player.type === "Pitcher" ? "투수" : "타자"}
              </PlayerType>
            </div>
            <PlayerInfoArea>
              <Player>{player.name}</Player>
              {player.type === "Pitcher"
                ? templatePitcher(player)
                : templateBatter(player)}
            </PlayerInfoArea>
          </div>
        );
      })}
    </PlayerInfoWrap>
  );
}

const PlayerInfoWrap = styled.div`
  display: inline-block;
  font-size: 25px;
`;

const PlayerType = styled.span`
  display: inline-block;
  margin-bottom: 8px;
  color: ${(props) => props.theme.mainFontColor};
`;

const PlayerInfoArea = styled.div`
  margin-bottom: 8px;
  font-size: 24px;
`;

const Player = styled.span`
  margin: 0 5px;
  color: #9cdafa;
`;

export default PlayerInfo;
