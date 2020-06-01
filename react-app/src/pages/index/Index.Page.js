import React from 'react';
import Row from 'react-bootstrap/Row';
import Col from 'react-bootstrap/Col';

import NewEvaluacionForm from '../../components/newevaluacion/NewEvaluacionForm.Component';

const IndexPage = () => {
    return (
        <Row>
            <Col></Col>
            <Col xs={12} lg={6} md={10}>
                <NewEvaluacionForm/>
            </Col>
            <Col></Col>
        </Row>
    );
};

export default IndexPage;