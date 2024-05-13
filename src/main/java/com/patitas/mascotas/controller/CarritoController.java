package com.patitas.mascotas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.patitas.mascotas.dto.CarritoDto;
import com.patitas.mascotas.service.CarritoService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/carrito")
@Api(value = "microservicio para obtener datos de articulos")
@CrossOrigin(origins= {"http://localhost:4200"})
@Validated
public class CarritoController {
	@Autowired
	CarritoService carritoService;
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ApiOperation(value="ver lista de articulos", response = CarritoDto.class)
	@ApiResponses(value = {
			@ApiResponse(code=200,message = "OK, Lista de articulos encontrada")
		})
	public List<CarritoDto> getAllCarritos(){
		return carritoService.getAllCarritos();
	}

}
