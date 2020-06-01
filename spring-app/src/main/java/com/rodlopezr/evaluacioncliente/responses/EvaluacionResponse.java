package com.rodlopezr.evaluacioncliente.responses;

import com.rodlopezr.evaluacioncliente.models.Evaluacion;

public class EvaluacionResponse {

	public Evaluacion data;
	public int code = 1;
	public String message;
		
	public EvaluacionResponse Ok(Evaluacion data) {
		message = ""; this.data = data;
		return this;
	}

	
	public EvaluacionResponse Error(String error) {
		message = error; code = 0;
		return this;
	}
}
