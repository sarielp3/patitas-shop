package com.patitas.mascotas.models;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import jakarta.persistence.Column;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.SequenceGenerator;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "ARTICULOS")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ArticulosEntity implements Serializable {
	
	@Id
    @SequenceGenerator(name = "articulos", sequenceName = "arti_seq", initialValue = 1, allocationSize = 1)
    @GeneratedValue(generator = "articulos")
    private Integer idArticulo;
	
	@Column(name="NOMBRE",nullable=false)
	private String nombre;
	
	@Column(name="PRECIO",nullable=false)
	private Float precio;
	
	@Column(name="STATUS",nullable=false)
	private char status;
	
	@Column(name="STOCK",nullable=false)
	private int stock;
	
	@Lob
	@Column(name="FOTO",nullable=true)
	private byte[] foto;
	
	@Column(name="FECHA_SUBIDA",nullable=false)
	private Date fechaSubida;
	
	@Column(name="DESCRIPCION",nullable=false)
	private String descripcion;
	
	@ManyToOne
	@JoinColumn(name="ID_CATEGORIA")
	private CategoriasEntity categorias;
	
	
	
}
