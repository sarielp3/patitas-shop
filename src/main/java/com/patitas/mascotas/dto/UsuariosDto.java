package com.patitas.mascotas.dto;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsuariosDto implements Serializable {
	
	private Integer idUsuario;
	
	private String nombre;
	
	private String correo;
	
	private String contra;
	
	private char status;
	
	private Date fecha;
	
	private BigInteger telefono;
	
	private char cuentaConf;
	
	private String nomUsuario;

}
