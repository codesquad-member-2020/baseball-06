import React from "react";
import GameSelectionPage from "./components/GameSelection/GameSelectionPage.jsx";
import Defense from "./components/GameProgression/Defense.jsx";
import { BrowserRouter, Route } from "react-router-dom";

function App() {
  return (
    <BrowserRouter>
      <Route path="/" exact component={GameSelectionPage} />
      <Route path="/Defense" exact component={Defense} />
    </BrowserRouter>
  );
}

export default App;
