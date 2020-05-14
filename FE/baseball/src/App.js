import React from "react";
import GameSelectionPage from "./components/GameSelection/GameSelectionPage.jsx";
import Defense from "./components/GameProgression/Defense.jsx";
import GameLog from "./components/GameProgression/GameLog";
import Offense from "./components/GameProgression/Offense.jsx";
import DetailedScorePage from "./components/GameInfo/DetailedScorePage";
import PlayerRoster from "./components/GameInfo/PlayerRoster";
import Nav from "./components/Header/Nav";
import Header from "./components/Header/Header";
import { GlobalStyle, Background } from "./styles/global";
import theme from "./styles/theme";
import { ThemeProvider } from "styled-components";
import Store from "./store/Store";

import { BrowserRouter, Route } from "react-router-dom";

function App() {
  return (
    <BrowserRouter>
      <Route
        path="/"
        exact
        render={(props) => (
          <Store>
            <GameSelectionPage {...props} />
          </Store>
        )}
      />
      <Route
        path="/defense"
        exact
        render={(props) => (
          <Store>
            <Defense {...props} />
          </Store>
        )}
      />
      <Route
        path="/log"
        exact
        render={(props) => (
          <Store>
            <GameLog {...props} />
          </Store>
        )}
      />
      <Route
        path="/offense"
        exact
        render={(props) => (
          <Store>
            <Offense {...props} />
          </Store>
        )}
      />
      <Route
        path="/detailedScore"
        exact
        render={(props) => (
          <Store>
            <DetailedScorePage {...props} />
          </Store>
        )}
      />
      <Route
        path="/playerRoster"
        exact
        render={(props) => (
          <Store>
            <PlayerRoster {...props} />
          </Store>
        )}
      />
    </BrowserRouter>
  );
}

export default App;
