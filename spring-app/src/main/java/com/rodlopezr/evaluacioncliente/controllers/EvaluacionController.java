package com.rodlopezr.evaluacioncliente.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.rodlopezr.evaluacioncliente.models.Cliente;
import com.rodlopezr.evaluacioncliente.models.Evaluacion;
import com.rodlopezr.evaluacioncliente.services.ClienteServices;
import com.rodlopezr.evaluacioncliente.services.EvaluacionServices;
import com.rodlopezr.evaluacioncliente.utils.Constantes;
import com.rodlopezr.evaluacionclientes.responses.EvaluacionResponse;
import com.rodlopezr.evaluacionclientes.responses.ListEvaluacionResponse;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/api")
@CrossOrigin(origins = "*")
@Api(value="onlinestore", description="Evaluación del Sistema")
public class EvaluacionController {

    private final static Logger LOGGER = LoggerFactory.getLogger(EvaluacionController.class);
    private final EvaluacionServices oService;

    public EvaluacionController(EvaluacionServices oService) {this.oService = oService;}

	@GetMapping("evaluacion")
	@ApiOperation(value = "Lista evaluaciones registradas", response = Cliente.class, responseContainer="List")
	@ApiResponses(value = {
        @ApiResponse(code = 200, message = Constantes.ApiResponse200),
        @ApiResponse(code = 401, message = Constantes.ApiResponse401),
        @ApiResponse(code = 403, message = Constantes.ApiResponse403),
        @ApiResponse(code = 404, message = Constantes.ApiResponse404)
	})
	public ResponseEntity<ListEvaluacionResponse> ListCliente() {
		try {
			return ResponseEntity.ok(oService.findAll());
		}catch(Exception oEx) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}

	@PostMapping("evaluacion")
    @ResponseStatus(HttpStatus.CREATED)
	@ApiOperation(value = "Registro de evaluacion nueva", response = Evaluacion.class, responseContainer="List")
	@ApiResponses(value = {
        @ApiResponse(code = 200, message = Constantes.ApiResponse200),
        @ApiResponse(code = 401, message = Constantes.ApiResponse401),
        @ApiResponse(code = 403, message = Constantes.ApiResponse403),
        @ApiResponse(code = 404, message = Constantes.ApiResponse404)
	})
	public ResponseEntity<EvaluacionResponse> Save(@RequestBody Evaluacion evaluacion) {
		try {
			return ResponseEntity.ok(oService.save(evaluacion));
		}catch(Exception oEx) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}

	@GetMapping("evaluacion/{id}")
	@ApiOperation(value = "Búsqueda de evaluación por Identificador", response = Cliente.class, responseContainer="ResponseEntity")
	@ApiResponses(value = {
	        @ApiResponse(code = 200, message = Constantes.ApiResponse200),
	        @ApiResponse(code = 401, message = Constantes.ApiResponse401),
	        @ApiResponse(code = 403, message = Constantes.ApiResponse403),
	        @ApiResponse(code = 404, message = Constantes.ApiResponse404)
	})
	public ResponseEntity<EvaluacionResponse> Find(@PathVariable String id) {
		try {
			return ResponseEntity.ok(oService.findOne(id));
		}catch(Exception oEx) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
	
    @PutMapping("evaluacion")
	@ApiOperation(value = "Actualización de registro de evaluaciones", response = Long.class, responseContainer="ResponseEntity")
	@ApiResponses(value = {
        @ApiResponse(code = 200, message = Constantes.ApiResponse200),
        @ApiResponse(code = 401, message = Constantes.ApiResponse401),
        @ApiResponse(code = 403, message = Constantes.ApiResponse403),
        @ApiResponse(code = 404, message = Constantes.ApiResponse404)
	})
    public ResponseEntity<EvaluacionResponse> Update(@RequestBody Evaluacion oCliente) {        
		try {
	        return ResponseEntity.ok(oService.update(oCliente));
		}catch(Exception oEx) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
    }

    @DeleteMapping("evaluacion/{id}")
	@ApiOperation(value = "Borrado de registro de evaluaciones", response = Long.class, responseContainer="ResponseEntity")
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

	@GetMapping("cliente/evaluacion/{id}/{fechaini}/{fechafin}")
	@ApiOperation(value = "Lista evaluaciones registradas, lista por cliente", response = Evaluacion.class, responseContainer="List")
	@ApiResponses(value = {
        @ApiResponse(code = 200, message = Constantes.ApiResponse200),
        @ApiResponse(code = 401, message = Constantes.ApiResponse401),
        @ApiResponse(code = 403, message = Constantes.ApiResponse403),
        @ApiResponse(code = 404, message = Constantes.ApiResponse404)
	})
	public ResponseEntity<ListEvaluacionResponse> ListEvaluacionXCliente(@PathVariable String id, @PathVariable String fechaini, @PathVariable String fechafin) {
		try {
			if(fechaini != null && fechafin != null 
					&& !fechaini.equals("") && !fechafin.equals("")) {
				//return ResponseEntity.ok(oService.findXClienteXFechas(id, fechaini, fechafin));
				return ResponseEntity.ok(oService.findAll());
			}else {
				return ResponseEntity.ok(oService.findXCliente(id));
			}
		}catch(Exception oEx) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
}
