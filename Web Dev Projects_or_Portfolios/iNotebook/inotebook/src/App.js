import "./App.css";
import Navbar from "./Components/Navbar";
import "./custom.scss";
import Home from "./Components/Home";
import About from "./Components/About";
import { BrowserRouter as Router, Switch, Route } from "react-router-dom";
import NoteState from "./context/notes/NoteState";
import LandingPage from "./Components/LandingPage";
import Login from "./Components/Login";
import Signup from "./Components/Signup";

function App() {
  return (
    <div>
      <Router>
        <NoteState>
          <Navbar title="iNotebook" />
          {/* <div className="container"> */}
          <Switch>
            <Route exact path="/">
              <LandingPage />
            </Route>
            <Route exact path="/home">
              <Home />
            </Route>
            <Route exact path="/about">
              <About />
            </Route>
            <Route exact path="/login">
              <Login />
            </Route>
            <Route exact path="/signup">
              <Signup />
            </Route>
          </Switch>
          {/* </div> */}
        </NoteState>
      </Router>
    </div>
  );
}

export default App;
