package com.rodlopezr.evaluacioncliente.services;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.rodlopezr.evaluacioncliente.models.Evaluacion;
import com.rodlopezr.evaluacioncliente.repository.IClienteRepository;
import com.rodlopezr.evaluacioncliente.repository.IEvaluacionRepository;

@Service
public class EvaluacionServices {

    private final IEvaluacionRepository oRepository;

    public EvaluacionServices(IEvaluacionRepository oRepository) {
    	this.oRepository = oRepository;
    }

	public List<Evaluacion> findAll() throws Exception {
        return oRepository.findAll();
	}

	public Evaluacion findOne(String id) throws Exception {
        if (id == null) throw new Exception("No Id selected");
        return oRepository.findById(id).get();
	}

	public Evaluacion save(Evaluacion oModel) throws Exception {
        if (oModel.getIdCliente() == null) throw new Exception("No cliente");
        oModel.RegisterDate();

    	oModel.setId(UUID.randomUUID().toString());
        return oRepository.save(oModel);
	}

	public Evaluacion update(Evaluacion oModel) throws Exception {
        if (oModel.getId() == null) throw new Exception("No Id selected");
        oModel.setActualizacion();
        return oRepository.save(oModel);
    }

	public long delete(String id) throws Exception {
        if (id == null) throw new Exception("No Id selected");
        oRepository.deleteById(id); return 1;
	}

	public List<Evaluacion> findXCliente(String idCliente) throws Exception {
        if (idCliente == null) throw new Exception("No Id selected");
        return oRepository.findXCliente(idCliente);
	}

	public List<Evaluacion> findXClienteXFechas(String idCliente, String fechaini, String fechafin) throws Exception {
        if (idCliente == null) throw new Exception("No Id selected");    
        return oRepository.findXFechas(idCliente, fechaini, fechafin);
	}
}
