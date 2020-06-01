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
	private String id;
	private String nombre;
	private String email;
	
	public Cliente() { }
	
	public Cliente(String id, String nombre, String email) {
		this.id = id;
		this.nombre = nombre;
		this.email = email;
	}

	public Cliente setId(String id) {
		this.id = id; return this;
	}

	public Cliente setNombre(String nombre) {
		this.nombre = nombre; return this;
	}

	public Cliente setEmail(String email) {
		this.email = email; return this;
	}

	@ApiModelProperty(
		value = "Código identificador del cliente",
		name = "Id",
		dataType = "String",
		example = "000001",
		allowEmptyValue = true
	)
	public String getId() {
		return id;
	}
	
	@ApiModelProperty(
		value = "Nombre del cliente",
		name = "Nombre",
		dataType = "String",
		example = "Rodrigo López"
	)
	public String getNombre() {
		return nombre;
	}

	@ApiModelProperty(
		value = "Correo electrónico del cliente",
		name = "Email",
		dataType = "String",
		example = "test@domain.com"
	)
	public String getEmail() {
		return email;
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