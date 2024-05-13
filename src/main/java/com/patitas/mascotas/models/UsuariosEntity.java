package com.patitas.mascotas.models;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "USUARIOS")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsuariosEntity {
	
	@Id
	@SequenceGenerator(name = "usuarios", sequenceName = "arti_seq", initialValue = 1, allocationSize = 1)
    @GeneratedValue(generator = "usuarios")
	private Integer idUsuario;
	
	@Column(name="NOMBRE",nullable=false)
	private String nombre;
	
	@Column(name="CORREO",nullable=false)
	private String correo;
	
	@Column(name="CONTRA",nullable=false)
	private String contra;
	
	@Column(name="STATUS",nullable=false)
	private char status;
	
	@Column(name="FECHA",nullable=false)
	private Date fecha;
	
	@Column(name="TELEFONO",nullable=false)
	private BigInteger telefono;
	
	@Column(name="CUENTA_CONF",nullable=false)
	private char cuentaConf;
	
	@Column(name="NOM_USUARIO",nullable=false)
	private String nomUsuario;

}
