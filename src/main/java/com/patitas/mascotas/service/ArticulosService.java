package com.patitas.mascotas.service;

import java.util.List;

import com.patitas.mascotas.dto.ArticulosDto;
import com.patitas.mascotas.dto.RespuestaEliminarDto;

public interface ArticulosService {
	
	List<ArticulosDto> getAllArticulos();
	
	ArticulosDto createArticulo(ArticulosDto newArticulo);
	
	ArticulosDto updateArticulo(ArticulosDto updateArticulo, Integer idArticulo);
	
	RespuestaEliminarDto deleteArticulo(Integer idArticulo);
}
