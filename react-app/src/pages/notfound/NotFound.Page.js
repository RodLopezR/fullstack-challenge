import React from 'react';
import { useHistory } from 'react-router-dom';
import Row from 'react-bootstrap/Row';
import Col from 'react-bootstrap/Col';
import Button from 'react-bootstrap/Button';

import { Routes } from '../../components/routes/Routes';

const IndexPage = () => {

    const history = useHistory();
    const onHandleNew = () => history.push(Routes.Home);

    return (
        <Row>
            <Col></Col>
            <Col xs={12} lg={5} md={7}>
                <p>No encontramos lo que estas buscando</p>
                <Button onClick={onHandleNew}>Volver a inicio</Button>
            </Col>
            <Col></Col>
        </Row>
    );
};

export default IndexPage;