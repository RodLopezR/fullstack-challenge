import React, { useState, useEffect } from 'react';
import Toast from 'react-bootstrap/Toast';
import { connect } from 'react-redux';
import { createStructuredSelector } from 'reselect';

import { selectToast } from '../../redux/notification/notification.selectors';
import { addNotification } from '../../redux/notification/notification.actions';

const ToastComponent = ({ toast, addNotification }) => {
    
    const [show, setShow] = useState(false);

    const handle = () => {
        setShow(false);
        addNotification(null);
    }

    useEffect(() => {
        setShow(toast !== null)
    }, [toast]);

    return (
        (toast !== null) ? (
            <div style={{ position: 'fixed', top: 0, right: 0, padding: '10px', alignContent: 'right' }}>
                <Toast className={toast.error ? 'ToastError' : 'ToastOk'} onClose={handle} show={show} delay={2000} autohide>
                    <Toast.Header>
                        <img src="holder.js/20x20?text=%20" className="rounded mr-2" alt=""/>
                        <strong className="mr-auto">{toast.error ? 'Alerta' : 'Mensaje'}</strong>
                        <small>Justo ahora</small>
                    </Toast.Header>
                    <Toast.Body>{toast.message}</Toast.Body>
                </Toast>
            </div>
        ) : ( null )
    );
}

const mapStateToProps =  createStructuredSelector({
    toast: selectToast
});

const mapDispatchToProps = dispatch => ({
    addNotification: toast =>  dispatch(addNotification(toast))
});

export default connect(mapStateToProps, mapDispatchToProps)(ToastComponent);