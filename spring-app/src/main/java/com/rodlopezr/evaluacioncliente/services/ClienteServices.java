package com.rodlopezr.evaluacioncliente.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.rodlopezr.evaluacioncliente.models.Cliente;
import com.rodlopezr.evaluacioncliente.repository.IClienteRepository;
import com.rodlopezr.evaluacioncliente.responses.ClienteResponse;
import com.rodlopezr.evaluacioncliente.responses.ListClienteResponse;

import java.util.UUID;

@Service
public class ClienteServices {

    private final IClienteRepository oRepository;

    public ClienteServices(IClienteRepository oRepository) {
    	this.oRepository = oRepository;
    }

    public ListClienteResponse findAll() throws Exception {
    	ListClienteResponse oResponse = new ListClienteResponse();
        return oResponse.Ok(oRepository.findAll());
    }

    public ClienteResponse findOne(String id) throws Exception {
    	ClienteResponse oResponse = new ClienteResponse();
        if (id == null) return oResponse.Error("Campo Id es necesario");
        Cliente oModel = oRepository.findById(id).get();
        return oResponse.Ok(oModel);
    }

    public ClienteResponse save(Cliente oModel) throws Exception {
    	ClienteResponse oResponse = new ClienteResponse();
    	
    	if(oModel.getEmail() == null) return oResponse.Error("Campo Email es necesario");
    	if(oModel.getNombre() == null) return oResponse.Error("Campo Nombre es necesario");
    	
    	List<Cliente> oVal = oRepository.findByEmail(oModel.getEmail());
    	if(oVal != null && oVal.size() > 0) return oResponse.Ok(oVal.get(0));
    	
    	oModel.setId(UUID.randomUUID().toString());
    	oModel = oRepository.save(oModel);
        return oResponse.Ok(oModel);
    }

    public ClienteResponse update(Cliente oCliente) throws Exception {
    	ClienteResponse oResponse = new ClienteResponse();
    	
        if (oCliente.getId() == null) return oResponse.Error("Campo Id es necesario");
    	if(oCliente.getEmail() == null) return oResponse.Error("Campo Email es necesario");
    	if(oCliente.getNombre() == null) return oResponse.Error("Campo Nombre es necesario");

    	List<Cliente> oVal = oRepository.findByEmail(oCliente.getEmail());
    	if(oVal != null && oVal.size() > 0 && oCliente.getId() != oVal.get(0).getId()) {
    		 return oResponse.Error("Email registrado con otra cuenta");
    	}

        Cliente oModel = oRepository.save(oCliente);
        return oResponse.Ok(oModel);
    }

    public long delete(String id) throws Exception {
        if (id == null) throw new Exception("No Id selected");
        oRepository.deleteById(id); return 1;
    }

    public ListClienteResponse findEmail(String email) throws Exception {
    	ListClienteResponse oResponse = new ListClienteResponse();
        return oResponse.Ok(oRepository.findByEmail(email));
    }
}