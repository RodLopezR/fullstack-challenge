import React from 'react';
import { connect } from 'react-redux';
import { useHistory } from 'react-router-dom';
import Button from 'react-bootstrap/Button';
import Row from 'react-bootstrap/Row';
import Col from 'react-bootstrap/Col';
import Card from 'react-bootstrap/Card';
import ButtonGroup from 'react-bootstrap/ButtonGroup';
import DropdownButton from 'react-bootstrap/DropdownButton';
import Dropdown from 'react-bootstrap/Dropdown';
import Calendar from 'react-calendar';
import FormControl from 'react-bootstrap/FormControl';

import { Routes } from '../routes/Routes';
import ParseDate from '../utils/DateParser';
import { addAccount } from '../../redux/account/account.actions';

const HeaderList = ({ account, addAccount, onLoad, date1, setDate1, date2, setDate2 }) => {

    const history = useHistory();
    const onHandleNew = () => history.push(Routes.Home);
    const onHandleClean = () => addAccount(null);
    
    const onChangeDate1 = date => setDate1({ show: false, value: date });
    const onChangeDate2 = date => setDate2({ show: false, value: date });

    const onClickCal1 = () => setDate1({ ...date1, show: !date1.show });
    const onClickCal2 = () => setDate2({ ...date2, show: !date2.show });

    const onHandle = () => onLoad();

    return (
        <Card style={{ marginBottom: '10px', color: 'black'}}>
            <Card.Body>
                <Row>
                    <Col lg={9}>
                        <div>{account.nombre}</div>
                        <div>{account.email}</div>
                    </Col>
                    <Col lg={3}>
                        <ButtonGroup>
                            <DropdownButton block="true" as={ButtonGroup} title="Opciones">
                                <Dropdown.Item eventKey="1" onClick={onHandleNew}>Nueva evaluación</Dropdown.Item>
                                <Dropdown.Item eventKey="2" onClick={onHandleClean}>Cerrar sesión</Dropdown.Item>
                            </DropdownButton>
                        </ButtonGroup>
                    </Col>
                </Row>
                <Row>
                    <Col lg={4}>
                        <span className="calendar-span">Desde:</span> 
                        <FormControl className="calendar-input" readOnly={true} value={ParseDate(date1.value)} onClick={onClickCal1} block="true"/>
                        { date1.show ? (
                            <Calendar className="calendar"
                                onChange={onChangeDate1}
                                value={date1.value}
                            />
                        ) : ( null )}
                    </Col>
                    <Col lg={4}>
                        <span className="calendar-span">Hasta:</span> 
                        <FormControl className="calendar-input" readOnly={true} value={ParseDate(date2.value)} onClick={onClickCal2} block="true"/>
                        <div>
                            { date2.show ? (
                                <Calendar className="calendar"
                                    onChange={onChangeDate2}
                                    value={date2.value}
                                />
                            ) : ( null )}
                        </div>
                    </Col>
                    <Col lg={4} style={{ position: 'relative'}}>
                        <Button 
                            onClick={onHandle}
                            style={{ position: 'absolute', bottom: '0', width: '92%' }}
                        >
                            Buscar
                        </Button>
                    </Col>
                </Row>
            </Card.Body>
        </Card>
    )
};

const mapDispatchToProps = dispatch => ({
    addAccount: account => dispatch(addAccount(account))
});

export default connect(null, mapDispatchToProps)(HeaderList);