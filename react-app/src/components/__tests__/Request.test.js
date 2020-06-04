import React from 'react';
import { ListarEvaluaciones } from '../request/EvaluacionRequest.Component';

describe('Request Component', function() {

    it("Test connection to backend", async done => {
        try {
            const response = await ListarEvaluaciones();
            expect(response).not.toBe(null);
            expect(response.length).not.toBe(0);
            done();
        }catch(ex){
            done(ex);
        }
    });

});