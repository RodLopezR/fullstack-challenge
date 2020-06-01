import React from 'react';
import Row from 'react-bootstrap/Row';
import Col from 'react-bootstrap/Col';
import { Star } from 'react-bootstrap-icons';

const StarItem = ({ value, index, onChange }) => {
    const baseColor = value > 8 ? '#50B04C' : ( value > 6 ? '#4AC28B' : ( value > 4 ? 'yellow' : ( value > 2 ? 'orange' : 'red')));
    const color = index <= value ? baseColor : 'black';

    return (
        <Col lg={1} md={1} xs={1} style={{ cursor: "pointer" }}  onClick={() => onChange(index)}>
            <Star style={{ cursor: "pointer", fontSize: '30' }} fill={color}/>
            <div style={{position: "absolute", top: 15, left: 27, fontSize: '10px'}}>{index}</div>
        </Col>
    );
}

const CalificadorMetro = ({ onChange, value }) => {

    let items = [];

    for(let i = 1; i < 11; i++){
        items.push(<StarItem key={i} value={value} index={i} onChange={onChange}/>);
    }

    return (
        <Row style={{color: 'black', marginBottom: '15px'}}>
            <Col lg={1} md={1} xs={1}></Col>
            {items}
            <Col lg={1} md={1} xs={1}></Col>
        </Row>
    )
};

export default CalificadorMetro;