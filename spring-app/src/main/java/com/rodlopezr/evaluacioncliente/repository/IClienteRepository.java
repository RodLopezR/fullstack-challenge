package com.rodlopezr.evaluacioncliente.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Component;
import org.springframework.data.repository.query.Param;

import com.rodlopezr.evaluacioncliente.models.Cliente;

@Component
public interface IClienteRepository extends MongoRepository<Cliente ,String> {
	
	@Query("{'email': '?0'}")
	public List<Cliente> findByEmail(String email) throws Exception;
}