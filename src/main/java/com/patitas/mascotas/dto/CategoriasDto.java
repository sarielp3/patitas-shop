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
public class CategoriasDto implements Serializable {

	
	private Integer idCategoria;
	
	private String descripcion;
	
	private Character status;


}
