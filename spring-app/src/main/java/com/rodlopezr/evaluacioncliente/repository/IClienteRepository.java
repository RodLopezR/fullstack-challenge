package com.rodlopezr.evaluacioncliente.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Component;

import com.rodlopezr.evaluacioncliente.models.Cliente;

@Component
public interface IClienteRepository extends MongoRepository<Cliente ,String> {
	
	@Query("{email : ?0}")
	public Cliente findEmail(String email) throws Exception;
}