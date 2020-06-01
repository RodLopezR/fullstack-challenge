import React from 'react';
import './styles/App.css';
import Container from 'react-bootstrap/Container';
import { Switch, Router, Route, Redirect } from 'react-router-dom';
import { createBrowserHistory } from 'history';

import IndexPage from './pages/index/Index.Page';
import EvaluacionPage from './pages/evaluaciones/Evaluacion.Page';
import NotFoundPage from './pages/notfound/NotFound.Page';

import { Routes } from './components/routes/Routes';
import Toast from './components/toast/Toast.Component';

const App = () => (
    <div className="App-header">
        <Container>
            <Router history={createBrowserHistory()}>
                <Switch>
                    <Route path={Routes.Home} exact component={IndexPage}/>
                    <Route path={Routes.Evaluaciones} exact component={EvaluacionPage}/>
                    <Route path={Routes.NotFound} exact component={NotFoundPage}/>
                    <Redirect to={Routes.NotFound} />
                </Switch>
            </Router>
        </Container>
        <Toast/>
    </div>
)

export default App;
