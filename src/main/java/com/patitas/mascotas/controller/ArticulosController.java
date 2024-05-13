package com.patitas.mascotas.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.patitas.mascotas.dto.ArticulosDto;
import com.patitas.mascotas.dto.RespuestaEliminarDto;
import com.patitas.mascotas.service.ArticulosService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;


@RestController
@RequestMapping("/articulos")
@Api(value = "microservicio para obtener datos de articulos")
@CrossOrigin(origins= {"http://localhost:4200"})
@Validated
public class ArticulosController {
	@Autowired
	ArticulosService articulosService;
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ApiOperation(value="ver lista de articulos", response = ArticulosDto.class)
	@ApiResponses(value = {
		@ApiResponse(code=200,message = "OK, Lista de articulos encontrada")
	})
	public List<ArticulosDto> getAllArticulos() {
		return articulosService.getAllArticulos();
	}
	
	@PostMapping(value="/nuevo-articulo",produces="application/json")
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
	@ApiOperation(value="Agregar nuevo articulo a DB", response = ArticulosDto.class)
	@ApiResponses(value = {
			@ApiResponse(code = 201, message = "Created, Registro de articulo nuevo exitoso"),
            @ApiResponse(code = 400, message = "Bad Request, Error en parametros de request body"),
            @ApiResponse(code = 404, message = "Not Found, No se encontraron los parametros vinculados con el articulo")
	})
	public ArticulosDto crearArticulo(@RequestBody ArticulosDto articulo) {
		
		return articulosService.createArticulo(articulo);
	}
	
	@PutMapping(value="/update-articulo/{id:[\\d]+}",produces="application/json")
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
	@ApiOperation(value="Actualizar articulo a DB", response = ArticulosDto.class)
	 @ApiResponses(value = {
				@ApiResponse(code = 201, message = "Created,Actualizacion de registro de articulo exitoso"),
	            @ApiResponse(code = 400, message = "Bad Request, Error en parametros de request body"),
	            @ApiResponse(code = 404, message = "Not Found, No se encontraron los parametros vinculados con el articulo")
		})
	public ArticulosDto updateArticulo(@PathVariable("id") Integer id,@RequestBody ArticulosDto updateArtic ) {
		return articulosService.updateArticulo(updateArtic, id);
	}
	
	@DeleteMapping(value="/eliminar-articulo/{id:[\\d]+}",produces="application/json")
	@ResponseBody
	@ResponseStatus(HttpStatus.ACCEPTED)
	@ApiOperation(value = "Eliminar registro de articulo")
	@ApiResponses(value = {
            @ApiResponse(code = 202, message = "Accepted, Se elimino el registro correctamente", response = ArticulosDto.class),
            @ApiResponse(code = 400, message = "Bad Request, Error en los parametros de busqueda"),
            @ApiResponse(code = 404, message = "Not Found, No se encontro el articulo con el identificador ingresado")
	})
	public RespuestaEliminarDto deleteArticulo(@PathVariable("id") Integer id) {
		return articulosService.deleteArticulo(id);
	}
}
