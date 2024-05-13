package com.patitas.mascotas.dto;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ArticulosDto implements Serializable {
	private Integer idArticulo;
	
	private String nombre;
	
	private Float precio;
	
	private Character status;
	
	private int stock;
	
	private byte[] foto;
	
	private Date fechaSubida;
	
	private String descripcion;
	
	private CategoriasDto categorias;
}
