import React from 'react';
import { ListarEvaluaciones } from '../request/EvaluacionRequest.Component';

describe('Request Component', function() {

    it("Test connection to backend", async () => {
        try {
            const response = await ListarEvaluaciones();
            console.log(response);
        }catch(ex){
            console.log(ex);
        }
    });

});