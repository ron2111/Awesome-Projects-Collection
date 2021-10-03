import React from 'react'
import {
  BrowserRouter as Router,
  Switch,
  Route,
} from "react-router-dom";
import FormPage from './components/form'
import Submissions from './components/submissions'
import Success from './components/success'

function App() {
  return (
    <>
      <Router>
        <Switch>
          <Route path="/" exact>
            <FormPage/>
          </Route>
          <Route path="/success" exact>
            <Success/>
          </Route>
          <Route path="/submissions" exact>
            <Submissions/>
          </Route>
        </Switch>
      </Router>
    </>
  );
}

export default App;
