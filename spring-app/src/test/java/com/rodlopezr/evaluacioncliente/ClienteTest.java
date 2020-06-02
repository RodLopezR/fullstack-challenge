package com.rodlopezr.evaluacioncliente;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.core.Is.is;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.rodlopezr.evaluacioncliente.controllers.ClienteController;
import com.rodlopezr.evaluacioncliente.models.Cliente;
import com.rodlopezr.evaluacioncliente.responses.ClienteResponse;

@SpringBootTest
@AutoConfigureMockMvc
public class ClienteTest {

	@Autowired
	private MockMvc mvc;
	
	@MockBean
	private ClienteController eController;

	@Test
	public void ListCliente() throws Exception {
		Cliente tmp = new Cliente("qwe", "Rodrigo", "emailtest@gmail.com");
		ClienteResponse oCliente = eController.Save(tmp).getBody();
		
		given(eController.Find(oCliente.data.getId())).willReturn(ResponseEntity.ok(oCliente));
		
		mvc.perform(MockMvcRequestBuilders.get("/api/cliente")
			.accept(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk());
	}

}