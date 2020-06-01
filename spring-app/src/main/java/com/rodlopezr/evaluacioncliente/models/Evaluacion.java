package com.rodlopezr.evaluacioncliente.models;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Document(collection = "evaluacion")
public class Evaluacion {

	@Id
	private String id;
	private String idcliente;
	private Integer evaluacion;
	private String registro;
	private String actualizacion;
	
	public Evaluacion() { }
	
	public Evaluacion(String id, String idcliente, Integer evaluacion, String registro, String actualizacion) {
		this.id = id;
		this.idcliente = idcliente;
		this.evaluacion = evaluacion;
		this.registro = registro;
		this.actualizacion = actualizacion;
	}
	
	@ApiModelProperty(
		value = "Código identificador de la evaluación",
		name = "Id",
		dataType = "String",
		example = "1",
		allowEmptyValue = true
	)
	public String getId() {
		return id;
	}

	@ApiModelProperty(
		value = "Código identificador del cliente",
		name = "IdCliente",
		dataType = "String",
		example = "1",
		allowEmptyValue = true
	)
	public String getIdCliente() {
		return idcliente;
	}

	@ApiModelProperty(
		value = "Valoración del cliente sobre Sistema",
		name = "Evaluacion",
		dataType = "Integer",
		example = "8"
	)
	public Integer getEvaluacion() {
		return evaluacion;
	}

	@ApiModelProperty(
		value = "Fecha de registro de evaluación",
		name = "registro",
		dataType = "String",
		example = "2020/05/2020 01:05:20",
		allowEmptyValue = true
	)
	public String getRegistro() {
		return registro;
	}

	@ApiModelProperty(
		value = "Fecha de actualización de evaluación",
		name = "actualizacion",
		dataType = "String",
		example = "2020/05/2020 01:05:20",
		allowEmptyValue = true
	)
	public String getActualizacion() {
		return actualizacion;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public void setIdCliente(String idcliente) {
		this.idcliente = idcliente;
	}
	
	public void setEvaluacion(Integer evaluacion) {
		this.evaluacion = evaluacion;
	}
	
	public void setActualizacion(String actualizacion) {
		this.actualizacion = actualizacion;
	}
	
	public void setRegistro(String registro) {
		this.registro = registro;
	}
	
	public void setActualizacion() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		setActualizacion(format.format(new Date()).toString());
	}
	
	public void RegisterDate() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		setRegistro(format.format(new Date()).toString());
		setActualizacion(format.format(new Date()).toString());
	}
}
