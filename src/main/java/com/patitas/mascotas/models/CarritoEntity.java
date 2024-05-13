package com.patitas.mascotas.models;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "CARRITO")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CarritoEntity implements Serializable {
	
	@Id
    @SequenceGenerator(name = "carrito", sequenceName = "arti_seq", initialValue = 1, allocationSize = 1)
    @GeneratedValue(generator = "carrito")
	private Integer idCarrito;
	
	@ManyToOne
	@JoinColumn(name="ID_ARTICULO")
	private ArticulosEntity articulo;
	
	@Column(name="NO_ARTICULOS",nullable=false)
	private int noArticulos;
	
	@ManyToOne
	@JoinColumn(name="ID_USUARIO")
	private UsuariosEntity idUsuario;
	
}
