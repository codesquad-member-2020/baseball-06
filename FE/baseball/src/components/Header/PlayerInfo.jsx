import React, { useContext } from "react";
import styled from "styled-components";
import { BaseBallContext } from "../GameProgression/Defense";

function PlayerInfo() {
  const { updatedPlayer } = useContext(BaseBallContext);
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
      {updatedPlayer.map((player, i) => {
        return (
          <div key={i + player}>
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
  overflow: hidden;
  max-height: 129px;
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
