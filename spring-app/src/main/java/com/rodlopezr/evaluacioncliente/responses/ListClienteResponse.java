package com.rodlopezr.evaluacioncliente.responses;

import java.util.List;

import com.rodlopezr.evaluacioncliente.models.Cliente;

public class ListClienteResponse {

	public List<Cliente> data;
	public int code = 1;
	public String message;
		
	public ListClienteResponse Ok(List<Cliente> data) {
		message = ""; this.data = data;
		return this;
	}

	public ListClienteResponse Error(String error) {
		message = error; code = 0;
		return this;
	}
}
