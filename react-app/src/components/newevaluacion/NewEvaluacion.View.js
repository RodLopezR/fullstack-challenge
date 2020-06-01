import React, { useState, useEffect } from 'react';
import InputGroup from 'react-bootstrap/InputGroup';
import Button from 'react-bootstrap/Button';
import Card from 'react-bootstrap/Card';
import Alert from 'react-bootstrap/Alert';
import Row from 'react-bootstrap/Row';
import Col from 'react-bootstrap/Col';
import FormEvaluacion from './NewEvaluacion.Form';

const NewEvaluacionForm = ({ submit, redirect, clean, account, disabled }) => {

    const [nombre, setNombre] = useState(account !== null ? account.nombre : "");
    const [email, setEmail] = useState(account !== null ? account.email : "");

    useEffect(() => {
        if(account !== null){
            setNombre(account.nombre);
            setEmail(account.email);
        }else{
            setNombre(""); setEmail("");
        }
    }, [account]);

    const onClean = (e) => {
        clean();
        setNombre(""); setEmail("");
    }

    const onRedirect = (e) => {
        redirect();
    }

    return (
        <Card>
            <Card.Img variant="top" src="header.png" style={{ maxHeight: 160, borderBottom: 'solid gray', borderBottomWidth: 1 }}/>
            <Card.Body>
                <Alert variant="success">
                    <h5>Hola!</h5>
                    <h5 style={{ fontSize: 15 }}>
                        Selecciona las estrellas en base a tu evaluación de nuestro servicio.
                    </h5>
                </Alert>
                <FormEvaluacion 
                    account={account} 
                    submit={submit} 
                    disabled={disabled} 
                    nombre={nombre} email={email}
                />
                {account !== null ? (
                    <Row>
                        <Col lg={6}>
                            <InputGroup className="mb-1">
                                <Button variant="outline-dark" block  onClick={onRedirect} disabled={disabled}>
                                    Ver evaluaciones
                                </Button>
                            </InputGroup>
                        </Col>
                        <Col lg={6}>
                        <InputGroup className="mb-1">
                            <Button variant="outline-dark" block  onClick={onClean} disabled={disabled}>
                                Cerrar sesión
                            </Button>
                        </InputGroup>
                        </Col>
                    </Row>
                ): null}
            </Card.Body>
        </Card>
    );
};

export default NewEvaluacionForm;