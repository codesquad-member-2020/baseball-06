import React, { createContext, useReducer, useMemo } from "react";
import styled, { ThemeProvider } from "styled-components";
const ballImg =
  "https://www.animatedimages.org/data/media/158/animated-baseball-image-0086.gif";


function DetailedScore(){
    return(
       <DetailedScoreTable>
        <thead>
            <tr>
                <th scope='col'></th>
            </tr>
        </thead>

       </DetailedScoreTable>
    )
}

const DetailedScoreTable = styled.table`
    margin: 100px auto;
    width: 950px;
    height: 200px;
    background: red;
`
export default DetailedScore;