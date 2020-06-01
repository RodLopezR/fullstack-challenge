package com.rodlopezr.evaluacioncliente.responses;

import java.util.List;

import com.rodlopezr.evaluacioncliente.models.Evaluacion;

public class ListEvaluacionResponse {

	public List<Evaluacion> data;
	public int code = 1;
	public String message;
		
	public ListEvaluacionResponse Ok(List<Evaluacion> data) {
		message = ""; this.data = data;
		return this;
	}

	public ListEvaluacionResponse Error(String error) {
		message = error; code = 0;
		return this;
	}
}
