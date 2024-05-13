package com.patitas.mascotas.service;

import java.util.List;

import com.patitas.mascotas.dto.Respuesta;
import com.patitas.mascotas.dto.RespuestaEliminarDto;
import com.patitas.mascotas.dto.UsuariosDto;

public interface UsuariosService {
	
	List<UsuariosDto> getAllUsuarios();
	
	UsuariosDto createUsuario(UsuariosDto newArticulo);
	
	UsuariosDto getUsuario(String usuario);
	
	RespuestaEliminarDto eliminarUsusario(Integer id);
	
}
