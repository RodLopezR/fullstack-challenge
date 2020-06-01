import React, { useState } from 'react';
import Table from 'react-bootstrap/Table';

import HeaderList from '../headerlist/HeaderList.Component';
import Paginator from '../paginator/Paginator.Component';
import ModalEdit from '../modaledit/ModalEdit.Component';
import ModalRemove from '../modaledit/ModalRemove.Component';
import ListItem from './ListItem.Component';
import { ListarEvaluacionesCliente } from '../request/EvaluacionRequest.Component';

import ParseDate from '../utils/DateParser';

const ListEvaluacion = ({ account }) => {
    
    const [date1, setDate1] = useState({ value: new Date(), show: false });
    const [date2, setDate2] = useState({ value: new Date(), show: false });

    const [data, setData] = useState({ data: [], error: false, loading: true });
    const [page, setPage] = useState(0);
    const [modalEdit, setModalEdit] = useState({ show: false, value: {}});
    const [modalRemove, setModalRemove] = useState({ show: false, value: {}});
    const rowsPerPage = 5;

    const onHandleEdit = (item) => setModalEdit({ show: true, value: item });
    const onHandleRemove = (item) => setModalRemove({ show: true, value: item });

    const LoadData = async () => {
        try {
            const Clientes = await ListarEvaluacionesCliente(account.id, ParseDate(date1.value), ParseDate(date2.value));
            setData({ data: Clientes, error: false, loading: false });
        } catch(ex) {
            setData({ data: [], error: true, loading: false });
        }
        setPage(0);
    }

    const renderTable = () => {
        const tmp = data.data.slice(rowsPerPage * page, (rowsPerPage * page) + rowsPerPage);
        if(tmp.length === 0){
            return (<tr>
                <td className="center" colSpan={4}>No hay datos</td>
            </tr>);
        }
        return tmp.map((item, index) => (
            <ListItem  key={index}
                index={index} item={item}
                onEdit={onHandleEdit} onRemove={onHandleRemove}
            />
        ));
    }

    return (
        <div>
            <HeaderList 
                account={account} 
                onLoad={LoadData}
                date1={date1} setDate1={setDate1}
                date2={date2} setDate2={setDate2}/>
            <Table striped bordered hover>
                <thead>
                    <tr>
                        <th>Calificación</th>
                        <th>Descripción</th>
                        <th>Fecha</th>
                        <th>Opciones</th>
                    </tr>
                </thead>
                <tbody>
                    {renderTable()}
                </tbody>
            </Table>
            {data.data ? (
                <Paginator page={page} setPage={setPage} max={Math.ceil(data.data.length / rowsPerPage)}/>
            ) : null }
            {modalEdit.show ? (
                <ModalEdit 
                    data={modalEdit} 
                    setData={setModalEdit}
                    onUpdate={LoadData}/>
            ) : null }
            {modalRemove.show ? (
                <ModalRemove 
                    data={modalRemove} 
                    setData={setModalRemove}
                    onRemove={LoadData}/>
            ) : null }
        </div>
    );
}

export default ListEvaluacion;