package com.patitas.mascotas.services.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import com.patitas.mascotas.dto.RespuestaEliminarDto;
import com.patitas.mascotas.dto.UsuariosDto;
import com.patitas.mascotas.exceptions.BusinessException;
import com.patitas.mascotas.models.UsuariosEntity;
import com.patitas.mascotas.repositories.UsuariosRepository;
import com.patitas.mascotas.service.UsuariosService;


@Service
public class UsuariosServiceImpl implements Serializable, UsuariosService {
	
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private UsuariosRepository usuariosRepository;
	
	@Autowired 
	private ModelMapper mapper;

	@Override
	public List<UsuariosDto> getAllUsuarios() {
		// TODO Auto-generated method stub
		return usuariosRepository.findAll().stream().map(UsuarioEntity -> mapper.map(UsuarioEntity,UsuariosDto.class))
				.collect(Collectors.toList());
	}

	@Override
	@Transactional
	public UsuariosDto createUsuario(UsuariosDto newUsuario) {
		Optional<UsuariosEntity> usuarioEntity = usuariosRepository.findByCorreo(newUsuario.getCorreo());
		if(usuarioEntity.isPresent()) {
			throw new ResponseStatusException(HttpStatus.FOUND,"Ya existe un registro con el correo ingresado");
		}
		Optional<UsuariosEntity> usuarioEntityTelefono = usuariosRepository.findByTelefono(newUsuario.getTelefono());
		if(usuarioEntityTelefono.isPresent()) {
			throw new ResponseStatusException(HttpStatus.FOUND,"Ya existe un registro con el telefono ingresado");
		}
		
		Optional<UsuariosEntity> usuarioEntityUsuario = usuariosRepository.findByNomUsuario(newUsuario.getNomUsuario());
		if(usuarioEntityUsuario.isPresent()) {
			throw new ResponseStatusException(HttpStatus.FOUND,"Ya existe un registro con el nombre de usuario ingresado");
		}
		UsuariosEntity newRegistro = this.mapper.map(newUsuario, UsuariosEntity.class);
		usuariosRepository.save(newRegistro);
		newUsuario.setIdUsuario(newRegistro.getIdUsuario());
		return newUsuario;
	}

	@Override
	public UsuariosDto getUsuario(String usuario) {
		Optional<UsuariosEntity> usuarioEntity = usuariosRepository.findByNomUsuario(usuario);
		
		if(!usuarioEntity.isPresent()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,"No existe un usuario con el nombre ingresado");
		}
		
		return this.mapper.map(usuarioEntity.get(), UsuariosDto.class);
	}

	@Override
	public RespuestaEliminarDto eliminarUsusario(Integer id) {
		RespuestaEliminarDto mensaje = new RespuestaEliminarDto();
		
		boolean usuarioExiste = usuariosRepository.existsById(id);
		
		if(usuarioExiste==false) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,"No existe un usuario con el ID ingresado");
		}
		usuariosRepository.deleteById(id);
		mensaje.setMensajeRespuesta("Usuario Eliminado con Exito!");
		return mensaje;
	}	

}
