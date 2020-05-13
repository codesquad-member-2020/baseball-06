import React from "react";
import GameSelectionPage from "./components/GameSelection/GameSelectionPage.jsx";
import Defense from "./components/GameProgression/Defense.jsx";
import GameLog from "./components/GameProgression/GameLog";
import Offense from "./components/GameProgression/Offense.jsx";
import DetailedScore from "./components/GameInfo/DetailedScore";
import PlayerRoster from "./components/GameInfo/PlayerRoster";
import Nav from "./components/Header/Nav";
import Header from "./components/Header/Header";
import { GlobalStyle, Background } from "./styles/global";
import theme from "./styles/theme";
import { ThemeProvider } from "styled-components";
import GameRouting from './GameRouting'

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
