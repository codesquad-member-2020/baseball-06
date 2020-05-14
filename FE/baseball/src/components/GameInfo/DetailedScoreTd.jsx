import React, { useContext, useEffect, useState } from "react";
import { inningInfoKey } from "../../constants/dataKey";

import { BaseballContext } from "../../store/Store";

function DetailedScoreTd({ roundLength }) {
  const { inningScore } = useContext(BaseballContext);

  const getLastTd = (i) => {
    if (i >= roundLength) return <th key={i} className={"total-score"}></th>;
  };

  const getTdList = () => {
    return Array(roundLength + 1)
      .fill()
      .map((_, i) => {
        getLastTd(i);
        return <td key={i + 1}></td>;
      });
  };

  const [tdList, setTdList] = useState(getTdList());

  const getSocreData = () => {
    const emptyArray = 0;
    if (inningScore.length === emptyArray) return;

    const copiedTdList = [...tdList];
    const { id, score } = inningInfoKey;

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
