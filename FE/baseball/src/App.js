import React from "react";
import GameSelectionPage from "./components/GameSelection/GameSelectionPage.jsx";
import Defense from "./components/Defense/Defense.jsx";
import { BrowserRouter, Route } from "react-router-dom";

function App() {
  return (
    <BrowserRouter>
      <div>
        <Route path="/" exact component={GameSelectionPage} />
        <Route path="/Defense" exact component={Defense} />
      </div>
    </BrowserRouter>
  );
}

export default App;
