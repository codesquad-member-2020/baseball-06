import React, { useContext, useEffect, useState } from "react";
import { teamInningInfoKey } from "../../constants/dataKey";

import { BaseballContext } from "../../store/Store";

function DetailedScoreTd({ roundLength }) {
  const { inningScore, totalScore } = useContext(BaseballContext);
  console.log(totalScore);

  const getLastTd = (i) => {
    return (
      <td key={i + 1} className={"total-score"}>
        {totalScore}
      </td>
    );
  };

  const getTdList = () => {
    return Array(roundLength)
      .fill()
      .map((_, i) => {
        return <td key={i + 1}></td>;
      });
  };

  const [tdList, setTdList] = useState(getTdList());

  const getSocreData = () => {
    const emptyArray = 0;
    if (inningScore.length === emptyArray) return;

    const copiedTdList = [...tdList];
    const { id, score } = teamInningInfoKey;

    const tdHtmlList = inningScore.reduce((td, inningData, i) => {
      td[i] = <td key={inningData[id]}>{inningData[score]}</td>;
      return td;
    }, copiedTdList);
    setTdList(tdHtmlList);
  };

  useEffect(() => {
    getSocreData();
  }, [inningScore]);

  return (
    <>
      {tdList}
      <td key={"lastTd"} className={"total-score"}>
        {totalScore}
      </td>
    </>
  );
}

export default DetailedScoreTd;
