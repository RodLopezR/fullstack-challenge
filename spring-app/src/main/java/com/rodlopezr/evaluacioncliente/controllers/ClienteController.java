package com.rodlopezr.evaluacioncliente.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.rodlopezr.evaluacioncliente.models.Cliente;
import com.rodlopezr.evaluacioncliente.services.ClienteServices;
import com.rodlopezr.evaluacioncliente.utils.Constantes;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

@RestController
@Slf4j
@RequestMapping("/api")
@CrossOrigin(origins = "*")
@Api(value="onlinestore", description="Clientes del Sistema")
public class ClienteController {

    private final static Logger LOGGER = LoggerFactory.getLogger(ClienteController.class);
    private final ClienteServices oService;

    public ClienteController(ClienteServices oService) {this.oService = oService;}
    
	/*@Autowired
	private ClienteRepository oRepository;*/

	@GetMapping("cliente")
	@ApiOperation(value = "Lista clientes registrados", response = Cliente.class, responseContainer="List")
	@ApiResponses(value = {
        @ApiResponse(code = 200, message = Constantes.ApiResponse200),
        @ApiResponse(code = 401, message = Constantes.ApiResponse401),
        @ApiResponse(code = 403, message = Constantes.ApiResponse403),
        @ApiResponse(code = 404, message = Constantes.ApiResponse404)
	})
	public ResponseEntity<List<Cliente>> ListCliente() {
		try {
			return ResponseEntity.ok(oService.findAll());
		}catch(Exception oEx) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}

	@GetMapping("cliente/{id}")
	@ApiOperation(value = "Búsqueda de Cliente por Identificador", response = Cliente.class, responseContainer="ResponseEntity")
	@ApiResponses(value = {
	        @ApiResponse(code = 200, message = Constantes.ApiResponse200),
	        @ApiResponse(code = 401, message = Constantes.ApiResponse401),
	        @ApiResponse(code = 403, message = Constantes.ApiResponse403),
	        @ApiResponse(code = 404, message = Constantes.ApiResponse404)
	})
	public ResponseEntity<Cliente> Find(@PathVariable String id) {
		try {
			return ResponseEntity.ok(oService.findOne(id));
		}catch(Exception oEx) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}

	@PostMapping("cliente")
    @ResponseStatus(HttpStatus.CREATED)
	@ApiOperation(value = "Registro de cliente nuevo", response = Cliente.class, responseContainer="ResponseEntity")
	@ApiResponses(value = {
        @ApiResponse(code = 200, message = Constantes.ApiResponse200),
        @ApiResponse(code = 401, message = Constantes.ApiResponse401),
        @ApiResponse(code = 403, message = Constantes.ApiResponse403),
        @ApiResponse(code = 404, message = Constantes.ApiResponse404)
	})
	public ResponseEntity<Cliente> Save(@RequestBody Cliente cliente) {
		try {
			return ResponseEntity.ok(oService.save(cliente));
		}catch(Exception oEx) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}

    @PutMapping("cliente")
	@ApiOperation(value = "Actualización de registro de cliente", response = Cliente.class, responseContainer="ResponseEntity")
	@ApiResponses(value = {
        @ApiResponse(code = 200, message = Constantes.ApiResponse200),
        @ApiResponse(code = 401, message = Constantes.ApiResponse401),
        @ApiResponse(code = 403, message = Constantes.ApiResponse403),
        @ApiResponse(code = 404, message = Constantes.ApiResponse404)
	})
    public ResponseEntity<Cliente> Update(@RequestBody Cliente oCliente) {        
		try {
	        oCliente = oService.update(oCliente);
	        if (oCliente == null)
	            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	        return ResponseEntity.ok(oCliente);
		}catch(Exception oEx) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
    }

    @DeleteMapping("cliente/{id}")
	@ApiOperation(value = "Borrado de registro de cliente", response = Long.class, responseContainer="ResponseEntity")
	@ApiResponses(value = {
        @ApiResponse(code = 200, message = Constantes.ApiResponse200),
        @ApiResponse(code = 401, message = Constantes.ApiResponse401),
        @ApiResponse(code = 403, message = Constantes.ApiResponse403),
        @ApiResponse(code = 404, message = Constantes.ApiResponse404)
	})
    public ResponseEntity<Long> deletePerson(@PathVariable String id) {
		try {
			return ResponseEntity.ok(oService.delete(id));
		}catch(Exception oEx) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
    }

    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public final Exception handleAllExceptions(RuntimeException e) {
        LOGGER.error("Internal server error.", e);
        return e;
    }
}
