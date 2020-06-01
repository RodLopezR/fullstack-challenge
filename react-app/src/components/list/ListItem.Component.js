import React from 'react';
import Button from 'react-bootstrap/Button';
import { StarsRender, Message } from '../stats/Stats.Component';
import { Trash, Pencil } from 'react-bootstrap-icons';

const ListItem = ({ index , item, onEdit, onRemove }) => {

    return (
        <tr>
            <td style={{ fontSize: '15px' }}><span>({item.evaluacion})</span> {StarsRender(item.evaluacion)}</td>
            <td style={{ fontSize: '15px' }}>{Message(item.evaluacion)}</td>
            <td style={{ fontSize: '15px' }}>{item.registro}</td>
            <td>
                <Button variant="warning" onClick={() => onEdit(item)}><Trash/> Editar</Button>{' '}
                <Button variant="danger" onClick={() => onRemove(item)}><Pencil/> Eliminar</Button>
            </td>
        </tr>
    );
}

export default ListItem;