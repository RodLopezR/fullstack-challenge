package com.rodlopezr.evaluacioncliente.models;

import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;

@Data
@Builder
@Document(collection = "cliente")
public class Cliente {

	@Id
	private String sId;
	private String sNombre;
	private String sEmail;
	
	public Cliente() { }
	
	public Cliente(String sId, String sNombre, String sEmail) {
		this.sId = sId;
		this.sNombre = sNombre;
		this.sEmail = sEmail;
	}

	public Cliente setId(String sId) {
		this.sId = sId; return this;
	}

	public Cliente setNombre(String sNombre) {
		this.sNombre = sNombre; return this;
	}

	public Cliente setEmail(String sEmail) {
		this.sEmail = sEmail; return this;
	}

	@ApiModelProperty(
		value = "Código identificador del cliente",
		name = "Id",
		dataType = "String",
		example = "000001",
		allowEmptyValue = true
	)
	public String getId() {
		return sId;
	}
	
	@ApiModelProperty(
		value = "Nombre del cliente",
		name = "Nombre",
		dataType = "String",
		example = "Rodrigo López"
	)
	public String getNombre() {
		return sNombre;
	}

	@ApiModelProperty(
		value = "Correo electrónico del cliente",
		name = "Email",
		dataType = "String",
		example = "test@domain.com"
	)
	public String getEmail() {
		return sEmail;
	}
	
	@Override
	public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Cliente cliente = (Cliente) o;
		return cliente.getEmail() == getEmail() && cliente.getId() == getId();
	}
}
