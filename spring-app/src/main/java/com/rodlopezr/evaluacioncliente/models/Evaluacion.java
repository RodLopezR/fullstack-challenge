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
	private String nId;
	private String nIdCliente;
	private Integer nEvaluacion;
	private String sRegistro;
	private String sActualizacion;
	
	public Evaluacion() { }
	
	public Evaluacion(String nId, String nIdCliente, Integer nEvaluacion, String sRegistro, String sActualizacion) {
		this.nId = nId;
		this.nIdCliente = nIdCliente;
		this.nEvaluacion = nEvaluacion;
		this.sRegistro = sRegistro;
		this.sActualizacion = sActualizacion;
	}
	
	@ApiModelProperty(
		value = "Código identificador de la evaluación",
		name = "Id",
		dataType = "String",
		example = "1",
		allowEmptyValue = true
	)
	public String getId() {
		return nId;
	}

	@ApiModelProperty(
		value = "Código identificador del cliente",
		name = "IdCliente",
		dataType = "String",
		example = "1",
		allowEmptyValue = true
	)
	public String getIdCliente() {
		return nIdCliente;
	}

	@ApiModelProperty(
		value = "Valoración del cliente sobre Sistema",
		name = "Evaluacion",
		dataType = "Integer",
		example = "8"
	)
	public Integer getEvaluacion() {
		return nEvaluacion;
	}

	@ApiModelProperty(
		value = "Fecha de registro de evaluación",
		name = "registro",
		dataType = "String",
		example = "2020/05/2020 01:05:20",
		allowEmptyValue = true
	)
	public String getRegistro() {
		return sRegistro;
	}

	@ApiModelProperty(
		value = "Fecha de actualización de evaluación",
		name = "actualizacion",
		dataType = "String",
		example = "2020/05/2020 01:05:20",
		allowEmptyValue = true
	)
	public String getActualizacion() {
		return sActualizacion;
	}
	
	public void setId(String nId) {
		this.nId = nId;
	}
	
	public void setIdCliente(String nIdCliente) {
		this.nIdCliente = nIdCliente;
	}
	
	public void setEvaluacion(Integer nEvaluacion) {
		this.nEvaluacion = nEvaluacion;
	}
	
	public void setActualizacion(String sActualizacion) {
		this.sActualizacion = sActualizacion;
	}
	
	public void setRegistro(String sRegistro) {
		this.sRegistro = sRegistro;
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
