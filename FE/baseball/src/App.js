import React from "react";
import GameSelectionPage from "./components/GameSelection/GameSelectionPage.jsx";
import Defense from "./components/GameProgression/Defense.jsx";
import GameLog from "./components/GameProgression/GameLog";
import Offense from "./components/GameProgression/Offense.jsx";
import DetailedScore from "./components/GameInfo/DetailedScore";
import PlayerRoster from "./components/GameInfo/PlayerRoster";
import { BrowserRouter, Route } from "react-router-dom";

function App() {
  return (
    <BrowserRouter>
      <Route path="/" exact component={GameSelectionPage} />
      <Route path="/defense" exact component={Defense} />
      <Route path="/log" exact component={GameLog} />
      <Route path="/offense" exact component={Offense} />
      <Route path="/detailedScore" exact component={DetailedScore} />
      <Route path="/playerRoster" exact component={PlayerRoster} />
    </BrowserRouter>
  );
}

export default App;
