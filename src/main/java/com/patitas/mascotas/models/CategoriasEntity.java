package com.patitas.mascotas.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.CascadeType;
import jakarta.persistence.FetchType;

@Entity
@Table(name = "CATEGORIAS")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoriasEntity  {
	
	@Id
    @SequenceGenerator(name = "categorias", sequenceName = "arti_seq", initialValue = 1, allocationSize = 1)
    @GeneratedValue(generator = "categorias")
    private Integer idCategoria;
	
	@Column(name="DESCRIPCION",nullable=false)
	private String descripcion;
	
	@Column(name="STATUS",nullable=false)
	private char status;
	
	@OneToMany(mappedBy = "categorias", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
	private List<ArticulosEntity> articulos;
	

}
