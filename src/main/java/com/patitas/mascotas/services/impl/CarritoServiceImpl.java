package com.patitas.mascotas.services.impl;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.patitas.mascotas.dto.CarritoDto;
import com.patitas.mascotas.repositories.CarritoRepository;
import com.patitas.mascotas.service.CarritoService;

@Service
public class CarritoServiceImpl implements Serializable, CarritoService {
	
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private CarritoRepository carritoRepository;
	
	@Autowired
	private ModelMapper mapper;

	@Override
	public List<CarritoDto> getAllCarritos() {
		// TODO Auto-generated method stub
		return carritoRepository.findAll().stream()
				.map(CarritoEntity -> mapper.map(CarritoEntity, CarritoDto.class))
				.collect(Collectors.toList());
	}

}
