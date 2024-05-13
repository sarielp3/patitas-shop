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
public class RespuestaEliminarDto implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String mensajeRespuesta;
}
