/* eslint-disable no-unused-vars */
import './App.css';
import {
  BrowserRouter as Router,
  Switch,
  Route,
  Link
} from "react-router-dom";
import Home from './pages/Home';

function App() {
  return (
    <Router>
    <div className="App">
        <Switch>
          <Route exact path="/">
              <Home/>
          </Route>
        </Switch>
    </div>
    </Router>
  );
}

export default App;
