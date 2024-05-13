package com.patitas.mascotas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.patitas.mascotas.dto.RespuestaEliminarDto;
import com.patitas.mascotas.dto.UsuariosDto;
import com.patitas.mascotas.service.UsuariosService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/usuarios")
@Api(value = "microservicio para obtener datos de usuarios")
@CrossOrigin(origins= {"http://localhost:4200"})
@Validated
public class UsuariosController {
	
	@Autowired
	UsuariosService usuariosService;
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ApiOperation(value="ver lista de articulos", response = UsuariosDto.class)
	@ApiResponses(value = {
		@ApiResponse(code=200,message = "OK, Lista de articulos encontrada")
	})
	
	public List<UsuariosDto> getAllUsuarios(){
		return usuariosService.getAllUsuarios();
	}
	
	@PostMapping(value="/nuevo-usuario",produces="application/json")
	@ResponseBody
	@ResponseStatus(HttpStatus.CREATED)
	@ApiOperation(value="Agregar nuevo Usuario a DB", response = UsuariosDto.class)
	@ApiResponses(value = {
			@ApiResponse(code = 201, message = "Created, Registro de usuario nuevo exitoso"),
            @ApiResponse(code = 400, message = "Bad Request, Error en parametros de request body"),
            @ApiResponse(code = 404, message = "Not Found, No se encontraron los parametros vinculados con el articulo")
	})
	public UsuariosDto crearUsuario(@RequestBody UsuariosDto usuario) {
		return usuariosService.createUsuario(usuario);
	}
	
	@GetMapping(value="/get-usuario/{usuario}", produces = "application/json")
	@ResponseBody
	@ApiOperation(value = "Ver usuario", response = UsuariosDto.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "OK, Hoteles encontrada"),
            @ApiResponse(code = 400, message = "Bad Request, Error en los parametros de busqueda"),
            @ApiResponse(code = 404, message = "Not Found, No se encontraron los parametros vinculados con el hotel")
	})
	public UsuariosDto getUsuario(@PathVariable String usuario) {
		if(usuario==null) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Nombre de usuario necesario");
		}
		
		return usuariosService.getUsuario(usuario);
	}
	
	@DeleteMapping(value="/delete-usuario/{id:[\\d]+}")
	@ResponseBody
	@ResponseStatus(HttpStatus.ACCEPTED)
	@ApiOperation(value = "Eliminar registro de usuario")
	@ApiResponses(value = {
            @ApiResponse(code = 202, message = "Accepted, Se elimino el registro correctamente", response = UsuariosDto.class),
            @ApiResponse(code = 400, message = "Bad Request, Error en los parametros de busqueda"),
            @ApiResponse(code = 404, message = "Not Found, No se encontro el hotel con el identificador ingresado")
	})
	public RespuestaEliminarDto  eliminarUsuario(@PathVariable("id") Integer id) {
		return usuariosService.eliminarUsusario(id);
	}
}
