package com.rodlopezr.evaluacioncliente.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Component;

import com.rodlopezr.evaluacioncliente.models.Evaluacion;

@Component
public interface IEvaluacionRepository extends MongoRepository<Evaluacion, String> {

	@Query("[{'idCliente' : '?0'}]")
	public List<Evaluacion> findXCliente(String idcliente) throws Exception;

	@Query("[{idCliente: ?0, registro : ?1}]")
	public List<Evaluacion> findXFechas(String idcliente, String fechaini, String fechafin) throws Exception;
}