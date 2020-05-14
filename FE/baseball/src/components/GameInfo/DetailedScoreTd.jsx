import React, { useContext, useEffect, useState } from "react";
import { teamInningInfoKey } from "../../constants/dataKey";

import { BaseballContext } from "../../store/Store";

function DetailedScoreTd({ roundLength }) {
  const { inningScore } = useContext(BaseballContext);

  const getLastTd = (i) => {
    return <td key={i + 1} className={"total-score"}></td>;
  };

  const getTdList = () => {
    return Array(roundLength + 1)
      .fill()
      .map((_, i) => {
        if (i >= roundLength) return getLastTd(i);
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

  return <>{tdList}</>;
}

export default DetailedScoreTd;
