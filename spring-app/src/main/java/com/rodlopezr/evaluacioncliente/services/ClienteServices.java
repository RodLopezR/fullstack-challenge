package com.rodlopezr.evaluacioncliente.services;

import java.util.List;

import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.mongodb.client.model.FindOneAndReplaceOptions;
import com.rodlopezr.evaluacioncliente.models.Cliente;
import com.rodlopezr.evaluacioncliente.repository.IClienteRepository;
import com.rodlopezr.evaluacioncliente.utils.Constantes;

import java.util.UUID;

import static com.mongodb.client.model.Filters.eq;

@Service
public class ClienteServices {

    private final IClienteRepository oRepository;

    public ClienteServices(IClienteRepository oRepository) {
    	this.oRepository = oRepository;
    }

    public List<Cliente> findAll() throws Exception {
        return oRepository.findAll();
    }

    public Cliente findOne(String id) throws Exception {
        if (id == null) throw new Exception("No Id selected");
        return oRepository.findById(id).get();
    }

    public Cliente save(Cliente oModel) throws Exception {
    	if(oModel.getEmail() == null) throw new Exception("No email");
    	if(oModel.getNombre() == null) throw new Exception("No nombre");
    	
    	if(findEmail(oModel) != null) throw new Exception("Email registrado!");
    	
    	oModel.setId(UUID.randomUUID().toString());
        return oRepository.save(oModel);
    }

    public Cliente update(Cliente oCliente) throws Exception {
        if (oCliente.getId() == null) throw new Exception("No Id selected");
    	if(oCliente.getEmail() == null) throw new Exception("No email");
    	if(oCliente.getNombre() == null) throw new Exception("No nombre");

    	Cliente oVal = findEmail(oCliente);
    	if(oVal != null && oCliente.getId() != oVal.getId()) {
    		 throw new Exception("Email registrado con otro usuario");
    	}

        return oRepository.save(oCliente);
    }

    public long delete(String id) throws Exception {
        if (id == null) throw new Exception("No Id selected");
        oRepository.deleteById(id); return 1;
    }

    public Cliente findEmail(Cliente oModel) throws Exception {
        if (oModel.getEmail() == null) throw new Exception("No email");
        return oRepository.findEmail(oModel.getEmail());
    }
}