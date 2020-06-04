package com.rodlopezr.evaluacioncliente;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import com.rodlopezr.evaluacioncliente.models.Evaluacion;
import com.rodlopezr.evaluacioncliente.services.EvaluacionServices;

@SpringBootTest
@AutoConfigureMockMvc
public class EvaluacionTest {

	@Autowired
	private EvaluacionServices evaluacionSevice;

	@Test
	public void ListEvaluaciones() throws Exception {
		List<Evaluacion> lClientes = evaluacionSevice.findAll().data;

		assertThat(lClientes.size()).isNotEqualTo(null);
		assertThat(lClientes.size()).isNotEqualTo(0);
		assertThat(lClientes.get(0).getIdCliente()).isNotEqualTo("");
		assertThat(lClientes.get(0).getIdCliente().length()).isNotEqualTo(0);
	}
}
