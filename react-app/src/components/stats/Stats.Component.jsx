import React from 'react';
import { Star } from 'react-bootstrap-icons';

const StarsRender = (count) => {
    switch(count){
        case 1: return <span><Star/></span>;
        case 2: return <span><Star/><Star/></span>;
        case 3: return <span><Star/><Star/><Star/></span>;
        case 4: return <span><Star/><Star/><Star/><Star/></span>;
        case 5: return <span><Star/><Star/><Star/><Star/><Star/></span>;
        case 6: return <span><Star/><Star/><Star/><Star/><Star/><Star/></span>;
        case 7: return <span><Star/><Star/><Star/><Star/><Star/><Star/><Star/></span>;
        case 8: return <span><Star/><Star/><Star/><Star/><Star/><Star/><Star/><Star/></span>;
        case 9: return <span><Star/><Star/><Star/><Star/><Star/><Star/><Star/><Star/><Star/></span>;
        case 10: return <span><Star/><Star/><Star/><Star/><Star/><Star/><Star/><Star/><Star/><Star/></span>;
        default: return null;
    }
};

const Message = (count) => {
    switch(count){
        case 1: return "Totalmente decepcionado del servicio 🤬";
        case 2: return "Mal servicio, lo evito en lo posible 🤕";
        case 3: return "Necesita mejorar 🗣";
        case 4: return "Requiere mejoras 🙅🏽‍♂️";
        case 5: return "Regular, no siempre funciona bien 🤷🏽‍♀️";
        case 6: return "Ha mejorado bastante 💅🏽";
        case 7: return "Me gusta 🤘🏽";
        case 8: return "Buen producto 💯";
        case 9: return "Excelente servicio, lo recomiendo ❤️";
        case 10: return "Amo el servicio! me encanta! 💖😍";
        default: return "";
    }
}


export {
    StarsRender,
    Message
}