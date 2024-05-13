package com.patitas.mascotas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.patitas.mascotas.models.CarritoEntity;

@Repository
public interface CarritoRepository extends JpaRepository<CarritoEntity, Integer> {

}
