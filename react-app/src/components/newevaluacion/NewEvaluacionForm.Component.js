import React, { useState } from 'react';
import { connect } from 'react-redux';
import { createStructuredSelector } from 'reselect';
import { useHistory } from 'react-router-dom';
import View from './NewEvaluacion.View';

import { addAccount } from '../../redux/account/account.actions';
import { addNotification } from '../../redux/notification/notification.actions';
import { selectAccount } from '../../redux/account/account.selectors';

import { Routes } from '../routes/Routes';

import { Registrar as RClinte } from '../request/ClienteRequest.Component';
import { Registrar as REvaluacion } from '../request/EvaluacionRequest.Component';

const NewEvaluacionForm = ({ addAccount, account, addNotification }) => {

    const [disabled, setDisabled] = useState(false);
    const history = useHistory();

    const onHandle = async (email, nombre, evaluacion) => {
        setDisabled(true);

        try{
            const reqCliente = { email, nombre };
            const oRespCliente = await RClinte(reqCliente);
            const oRespEval = await REvaluacion({ idCliente: oRespCliente.id, evaluacion });
            setTimeout(() => {
                addAccount(oRespCliente);
                history.push(Routes.Evaluaciones);
                addNotification({ message: "Se registró su evaluación con éxito", error: false });
                setDisabled(false);
            }, 2000);
        }catch(ex){
            setDisabled(false);
            addNotification({ message: ex.message, error: true });
        }
    }

    const onHandleClean = () => {
        addAccount(null);
    }

    const onHandleRedirect = () => {
        history.push(Routes.Evaluaciones);
    }

    return (
        <View 
            disabled={disabled}
            redirect={onHandleRedirect}
            clean={onHandleClean}
            submit={onHandle} 
            account={account}/>
    );
};


const mapStateToProps =  createStructuredSelector({
    account: selectAccount
});

const mapDispatchToProps = dispatch => ({
    addAccount: account => dispatch(addAccount(account)),
    addNotification: toast =>  dispatch(addNotification(toast))
});

export default connect(mapStateToProps, mapDispatchToProps)(NewEvaluacionForm);