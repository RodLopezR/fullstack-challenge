import React, { useState, useEffect } from 'react';
import InputGroup from 'react-bootstrap/InputGroup';
import FormControl from 'react-bootstrap/FormControl';
import Button from 'react-bootstrap/Button';
import Spinner from 'react-bootstrap/Spinner';
import { Star } from 'react-bootstrap-icons';
import { Formik } from 'formik';

import { Message } from '../stats/Stats.Component';
import CalificadorMetro from '../calificadormetro/CalificadorMetro.Component';


function validateEmail(value) {
    let error = null;
    if (!value) {
        error = 'Required';
    } else if (!/^[A-Z0-9._%+-]+@[A-Z0-9.-]+\.[A-Z]{2,4}$/i.test(value)) {
        error = 'Invalid email address';
    }
    return error;
}

function validateUsername(value) {
    let error = null;
    if (!value)
        error = 'Required';
    return error;
}

const NewForm = ({ account, nombre, email, submit, disabled }) => {

    const [calificacion, setCalificacion] = useState(5);
    const initials = { name: nombre, email: email };

    useEffect(() => {
        initials.name = nombre; 
        initials.email = email;
    }, [initials, nombre, email]);
    
    const onSubmitFormik = (values, actions) => {
        const valEmail = validateEmail(values.email);
        const valName = validateUsername(values.name);

        if(valEmail ||  valName){
            actions.setErrors({
                email: valEmail,
                name: valName,
            });
            return;
        }
        submit(values.email, values.name, calificacion);
    }

    return (
        <Formik initialValues={initials} onSubmit={onSubmitFormik}>
        {({ handleChange, handleSubmit, errors, values }) => (
            <div>
                <InputGroup className="mb-3">
                    <InputGroup.Prepend>
                        <InputGroup.Text id="basic-addon1">Email</InputGroup.Text>
                    </InputGroup.Prepend>
                    <FormControl
                        placeholder="test@gmail.com"
                        aria-label="email"
                        aria-describedby="basic-addon1"
                        name="email"
                        onChange={handleChange}
                        value={values.email}
                        isInvalid={errors.email}
                        disabled={disabled || account !== null}
                    />
                </InputGroup>
                <InputGroup className="mb-3">
                    <InputGroup.Prepend>
                        <InputGroup.Text id="basic-addon1">Nombre</InputGroup.Text>
                    </InputGroup.Prepend>
                    <FormControl
                        placeholder="Rodrigo López"
                        aria-label="name"
                        aria-describedby="basic-addon1"
                        name="name"
                        onChange={handleChange}
                        value={values.name}
                        isInvalid={errors.name}
                        disabled={disabled || account !== null}
                    />
                </InputGroup>
                <CalificadorMetro onChange={setCalificacion} value={calificacion}/>
                <div style={{ textAlign: 'center', color: 'black', paddingBottom: '10px'}}>{Message(calificacion)}</div>
                <InputGroup className="mb-1">
                    <Button variant="success" block onClick={handleSubmit} disabled={disabled}>
                        {disabled ? (
                            <Spinner animation="border" variant="primary" />
                        ): (
                            <Star /> 
                        )} Calificar
                    </Button>
                </InputGroup>
            </div>
        )}
        </Formik>
    )
}

export default NewForm;