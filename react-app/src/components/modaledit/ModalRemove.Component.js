import React, { useState } from 'react';
import Modal from 'react-bootstrap/Modal';
import Button from 'react-bootstrap/Button';
import { connect } from 'react-redux';
import { Crop, Trash } from 'react-bootstrap-icons';

import { Eliminar } from '../request/EvaluacionRequest.Component';
import { addNotification } from '../../redux/notification/notification.actions';

const ModalRemove = ({ data, setData, addNotification, onRemove }) => {
    
    const [disabled, setDisabled] = useState(false);

    const handleClose = () => {
        if(disabled) return; 
        setData({ show: false, value: {} });
    }
    
    const handleEvaluacion = async () => {
        setDisabled(true);
        let toast = {};
        try{
            await Eliminar(data.value.id);
            toast = { message: "Se eliminó la evaluación seleccionada", error: false };
        }catch(ex){
            toast = { message: ex.message, error: true };
        }

        setTimeout(() => {
            setData({ show: false, value: {} });
            addNotification(toast);
            onRemove();
        }, 1000);
    }

    return (
        <Modal show={data.show} onHide={handleClose}>
            <Modal.Header closeButton>
                <Modal.Title>Alerta</Modal.Title>
            </Modal.Header>
            <Modal.Body>¿Seguro que deseas remover esta evaluación? esta operación no se puede revertir.</Modal.Body>
            <Modal.Footer>
                <Button variant="secondary" onClick={handleClose} disabled={disabled}>
                    <Crop/> Cancelar
                </Button>
                <Button variant="danger" onClick={handleEvaluacion} disabled={disabled}>
                    <Trash/> Eliminar
                </Button>
            </Modal.Footer>
        </Modal>
    );
}

const mapDispatchToProps = dispatch => ({
    addNotification: toast =>  dispatch(addNotification(toast))
});

export default connect(null, mapDispatchToProps)(ModalRemove);