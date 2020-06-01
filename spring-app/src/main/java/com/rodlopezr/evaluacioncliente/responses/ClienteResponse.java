package com.rodlopezr.evaluacioncliente.responses;

import com.rodlopezr.evaluacioncliente.models.Cliente;

public class ClienteResponse  {

	public Cliente data;
	public int code = 1;
	public String message;
		
	public ClienteResponse Ok(Cliente data) {
		message = ""; this.data = data;
		return this;
	}

	
	public ClienteResponse Error(String error) {
		message = error; code = 0;
		return this;
	}
}
