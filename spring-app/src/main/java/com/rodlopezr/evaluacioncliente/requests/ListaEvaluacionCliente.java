package com.rodlopezr.evaluacioncliente.requests;

import io.swagger.annotations.ApiModelProperty;

public class ListaEvaluacionCliente  {

	private String idCliente;
	private String fechaini;
	private String fechafin;

	public ListaEvaluacionCliente setIdCliente(String idCliente) {
		this.idCliente = idCliente; return this;
	}

	public ListaEvaluacionCliente setFechaini(String fechaini) {
		this.fechaini = fechaini; return this;
	}

	public ListaEvaluacionCliente setFechafin(String fechafin) {
		this.fechafin = fechafin; return this;
	}

	@ApiModelProperty(
		value = "Identificador del cliente del cliente",
		name = "IdCliente",
		dataType = "String",
		example = "b4b7683b-ec33-47b2-a56c-8844258a13f4"
	)
	public String getIdCliente() {
		return idCliente;
	}

	@ApiModelProperty(
		value = "Filtro fecha inicio",
		name = "FechaIni",
		dataType = "String",
		example = "2020-03-20 00:00:01"
	)
	public String getFechaini() {
		return fechaini;
	}

	@ApiModelProperty(
		value = "Filtro fecha fin",
		name = "FechaFin",
		dataType = "String",
		example = "2020-06-20 00:00:01"
	)
	public String getFechafin() {
		return fechafin;
	}
}
