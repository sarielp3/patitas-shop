package com.patitas.mascotas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.patitas.mascotas.models.CategoriasEntity;

@Repository
public interface CategoriasRepository extends JpaRepository<CategoriasEntity,Integer> {

}
