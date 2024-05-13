package com.patitas.mascotas.services.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.patitas.mascotas.dto.ArticulosDto;
import com.patitas.mascotas.dto.RespuestaEliminarDto;
import com.patitas.mascotas.exceptions.ResourceNotFoundException;
import com.patitas.mascotas.models.ArticulosEntity;
import com.patitas.mascotas.repositories.ArticulosRepository;
import com.patitas.mascotas.service.ArticulosService;

@Service
public class ArticulosServiceImpl implements ArticulosService, Serializable {

	private static final long serialVersionUID = 1L;
	
	@Autowired
	private ArticulosRepository articulosRepository;
	
	@Autowired 
	private ModelMapper mapper;
	
	@Override
	public List<ArticulosDto> getAllArticulos() {
		// TODO Auto-generated method stub
		return articulosRepository.getAll().stream()
				.map(ArticulosEntity -> mapper.map(ArticulosEntity, ArticulosDto.class))
				.collect(Collectors.toList());
		
		
	}

	@Override
	@Transactional
	public ArticulosDto createArticulo(ArticulosDto newArticulo) {
		
		ArticulosEntity nuevoRegistro = this.mapper.map(newArticulo, ArticulosEntity.class);
		System.out.println(newArticulo);
		articulosRepository.save(nuevoRegistro);
		newArticulo.setIdArticulo(nuevoRegistro.getIdArticulo());
		
		return newArticulo;
	}

	@Override
	public ArticulosDto updateArticulo(ArticulosDto updateArticulo, Integer idArticulo) {
		Optional<ArticulosEntity> registro = articulosRepository.findById(idArticulo);
		
		registro.get().setNombre(updateArticulo.getNombre());
		registro.get().setPrecio(updateArticulo.getPrecio());
		registro.get().setStock(updateArticulo.getStock());
		registro.get().setFoto(updateArticulo.getFoto());
		registro.get().setFechaSubida(updateArticulo.getFechaSubida());
		registro.get().setDescripcion(updateArticulo.getDescripcion());
		articulosRepository.save(registro.get());
		updateArticulo.setIdArticulo(idArticulo);
		
		return updateArticulo;
	}

	@Override
	public RespuestaEliminarDto deleteArticulo(Integer idArticulo) {
		RespuestaEliminarDto mensaje = new RespuestaEliminarDto();
		boolean articuloExist = articulosRepository.existsById(idArticulo);
		if(articuloExist==false) {
			throw new ResourceNotFoundException("No se encontro ID del articulo");
		}
		
		articulosRepository.deleteById(idArticulo);
		mensaje.setMensajeRespuesta("Registro eliminado correctamente");
		return mensaje;
	}

}
