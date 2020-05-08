import React from "react";
import styled, { ThemeProvider } from "styled-components";
import theme from "../../styles/theme";

function PlayerInfo({ updatedPlayer }) {
  console.log(updatedPlayer);

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
          <>
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
          </>
        );
      })}
    </PlayerInfoWrap>
  );
}

const PlayerInfoWrap = styled.div`
position:absolute;
top:20px;
right:80px;
  font-size: 30px;
  /* color: ${(props) => props.theme.mainFontColor}; */
`;

const PlayerType = styled.span`
  display: inline-block;
  margin-bottom: 10px;
  font-size: 28px;
  color: ${(props) => props.theme.mainFontColor};
`;

const PlayerInfoArea = styled.div`
  font-size: 24px;
  margin-bottom: 15px;
`;

const Player = styled.span`
  margin: 0 5px;
  color: #fccf03;
`;

export default PlayerInfo;
