package com.rodlopezr.evaluacioncliente.services;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.rodlopezr.evaluacioncliente.models.Cliente;
import com.rodlopezr.evaluacioncliente.models.Evaluacion;
import com.rodlopezr.evaluacioncliente.repository.IClienteRepository;
import com.rodlopezr.evaluacioncliente.repository.IEvaluacionRepository;
import com.rodlopezr.evaluacionclientes.responses.ClienteResponse;
import com.rodlopezr.evaluacionclientes.responses.EvaluacionResponse;
import com.rodlopezr.evaluacionclientes.responses.ListClienteResponse;
import com.rodlopezr.evaluacionclientes.responses.ListEvaluacionResponse;

@Service
public class EvaluacionServices {

    private final IEvaluacionRepository oRepository;

    public EvaluacionServices(IEvaluacionRepository oRepository) {
    	this.oRepository = oRepository;
    }

	public ListEvaluacionResponse findAll() throws Exception {
		ListEvaluacionResponse oResponse = new ListEvaluacionResponse();
        return oResponse.Ok(oRepository.findAll());
	}

	public EvaluacionResponse findOne(String id) throws Exception {
		EvaluacionResponse oResponse = new EvaluacionResponse();
        if (id == null) return oResponse.Error("Campo Id es necesario");
        Evaluacion oModel = oRepository.findById(id).get();
        return oResponse.Ok(oModel);
	}

	public EvaluacionResponse save(Evaluacion oModel) throws Exception {
		EvaluacionResponse oResponse = new EvaluacionResponse();
    	
        if (oModel.getIdCliente() == null) return oResponse.Error("Campo IdCliente es necesario");
        oModel.RegisterDate();

    	oModel.setId(UUID.randomUUID().toString());
    	oModel = oRepository.save(oModel);
        return oResponse.Ok(oModel);
	}

	public EvaluacionResponse update(Evaluacion oModel) throws Exception {
		EvaluacionResponse oResponse = new EvaluacionResponse();
		
        if (oModel.getId() == null) return oResponse.Error("Campo Id es necesario");
        if (oModel.getIdCliente() == null) return oResponse.Error("Campo IdCliente es necesario");
        oModel.setActualizacion();

        Evaluacion oModel2 = oRepository.save(oModel);
        return oResponse.Ok(oModel2);
    }

	public long delete(String id) throws Exception {
        if (id == null) throw new Exception("No Id selected");
        oRepository.deleteById(id); return 1;
	}

	public ListEvaluacionResponse findXCliente(String idCliente) throws Exception {
		ListEvaluacionResponse oResponse = new ListEvaluacionResponse();
        if (idCliente == null) return oResponse.Error("Campo IdCliente es necesario");
        return oResponse.Ok(oRepository.findXCliente(idCliente));
	}

	public ListEvaluacionResponse findXClienteXFechas(String idCliente, String fechaini, String fechafin) throws Exception {
		ListEvaluacionResponse oResponse = new ListEvaluacionResponse();
        if (idCliente == null) return oResponse.Error("Campo IdCliente es necesario");  
        return oResponse.Ok(oRepository.findXFechas(idCliente, fechaini, fechafin));
	}
}
