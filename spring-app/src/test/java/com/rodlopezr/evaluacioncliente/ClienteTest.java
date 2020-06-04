package com.rodlopezr.evaluacioncliente;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import com.rodlopezr.evaluacioncliente.models.Cliente;
import com.rodlopezr.evaluacioncliente.services.ClienteServices;

@SpringBootTest
@AutoConfigureMockMvc
public class ClienteTest {
	
	@Autowired
	private ClienteServices clienteSevice;

	@Test
	public void ListCliente() throws Exception {
		List<Cliente> lClientes = clienteSevice.findAll().data;

		assertThat(lClientes.size()).isNotEqualTo(null);
		assertThat(lClientes.size()).isNotEqualTo(0);
	}

	@Test
	public void SaveAndFindCliente() throws Exception {
		Cliente oClienteTest = new Cliente("Test", "Rodrigo", "rlopez2512@gmail.com");
		
		Cliente oTestSave = clienteSevice.save(oClienteTest).data;
		Cliente oTestFind = clienteSevice.findOne(oTestSave.getId()).data;

		assertThat(oTestSave).isNotEqualTo(null);
		assertThat(oTestFind).isNotEqualTo(null);
		assertThat(oTestFind.getId()).isEqualTo(oTestSave.getId());
		assertThat(oTestFind.getEmail()).isEqualTo(oTestSave.getEmail());
	}
}