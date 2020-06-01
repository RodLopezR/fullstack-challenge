import React, { useState } from 'react';
import Modal from 'react-bootstrap/Modal';
import Button from 'react-bootstrap/Button';
import { connect } from 'react-redux';
import { Crop, Pencil } from 'react-bootstrap-icons';

import { Message } from '../stats/Stats.Component';
import CalificadorMetro from '../calificadormetro/CalificadorMetro.Component';
import { Actualizar } from '../request/EvaluacionRequest.Component';

import { addNotification } from '../../redux/notification/notification.actions';

const ModalEdit = ({ data, setData, addNotification, onUpdate }) => {
    
    const [disabled, setDisabled] = useState(false);
    const [evalItem, setEval] = useState(data.value);
    
    const handleClose = () => {
        if(disabled) return;
        setData({ show: false, value: {} });
    }
    
    const handleEvaluacion = async (e) => setEval({ ...evalItem, evaluacion: e}); 

    const handleActualizar = async (e) => {
        setDisabled(true);
        let toast = {};
        try{
            await Actualizar(evalItem);
            toast = { message: "Se actualizó la evaluación con éxito", error: false };
        }catch(ex){
            toast = { message: ex.message, error: true };
        }
        setTimeout(() => {
            setData({ show: false, value: {} });
            addNotification(toast);
            onUpdate();
        }, 1000);
    }

    return (
        <Modal show={data.show} onHide={handleClose}>
            <Modal.Header closeButton>
                <Modal.Title>Editar evaluación</Modal.Title>
            </Modal.Header>
            <Modal.Body>
                <CalificadorMetro onChange={handleEvaluacion} value={evalItem.evaluacion}/>
                <div style={{ textAlign: 'center', color: 'black', paddingBottom: '10px'}}>{Message(evalItem.evaluacion)}</div>
            </Modal.Body>
            <Modal.Footer>
                <Button variant="secondary" onClick={handleClose} disabled={disabled}>
                    <Crop/>Cancelar
                </Button>
                <Button variant="danger" onClick={handleActualizar} disabled={disabled}>
                    <Pencil/>Actualizar
                </Button>
            </Modal.Footer>
        </Modal>
    );
}

const mapDispatchToProps = dispatch => ({
    addNotification: toast =>  dispatch(addNotification(toast))
});

export default connect(null, mapDispatchToProps)(ModalEdit);