import React from 'react';
import Pagination from 'react-bootstrap/Pagination';

const Paginator = ({ page, setPage, max }) => {

    if(max <= 1) return null;

    const onClickPage = (number) => {
        setPage(number - 1);
    }

    let items = [];
    for (let number = 1; number <= max; number++) {
        items.push(
            <Pagination.Item key={number} active={number === (page + 1)} onClick={() => onClickPage(number)}>
            {number}
            </Pagination.Item>,
        );
    }

    return (
        <div>
            <Pagination size="sm">{items}</Pagination>
        </div>
    );
}

export default Paginator;