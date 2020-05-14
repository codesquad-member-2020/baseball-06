import React, { useContext, useEffect, useState } from "react";

import { BaseballContext } from "../../store/Store";

function DetailedScoreTd({ roundLength }) {
  const { inningScore } = useContext(BaseballContext);

  //   let tdList = [];
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
    if (inningScore.length === 0) return console.log(1);
    const copiedTdList = [...tdList];

    const tdHtmlList = inningScore.reduce((td, inningData, i) => {
      td[i] = <td key={inningData.id}>{inningData.score}</td>;
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
