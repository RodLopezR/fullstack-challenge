import React from 'react';
import { connect } from 'react-redux';
import { createStructuredSelector } from 'reselect';
import { useHistory } from 'react-router-dom';
import Row from 'react-bootstrap/Row';
import Col from 'react-bootstrap/Col';
import Button from 'react-bootstrap/Button';

import ListEvaluacion from '../../components/list/ListEvaluacion.Component';

import { Routes } from '../../components/routes/Routes';
import { selectAccount } from '../../redux/account/account.selectors';

const EvaluacionPage = ({ account }) => {

    const history = useHistory();
    const onHandleNew = () => history.push(Routes.Home);

    return (
        <Row>
            <Col></Col>
            <Col xs={12} lg={10} md={11}>
            {account !== null ? (
                <ListEvaluacion account={account}/>
            ) : (
                <div>
                    No ingresaste aun
                    <Button onClick={onHandleNew}>Registrar evaluación</Button>
                </div>
            )}
            </Col>
            <Col></Col>
        </Row>
    )
};

const mapStateToProps =  createStructuredSelector({
    account: selectAccount
});

export default connect(mapStateToProps)(EvaluacionPage);