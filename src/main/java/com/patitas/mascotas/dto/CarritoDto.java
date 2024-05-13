package com.patitas.mascotas.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CarritoDto implements Serializable {
	
	private Integer idCarrito;
	
	private ArticulosDto articulo;
	
	private Integer noArticulos;
	
	private UsuariosDto usuario;
	
}
