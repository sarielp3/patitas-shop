package com.patitas.mascotas.repositories;

import java.math.BigInteger;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.patitas.mascotas.models.UsuariosEntity;

@Repository
public interface UsuariosRepository extends JpaRepository<UsuariosEntity, Integer> {
		Optional<UsuariosEntity> findByCorreo(String correo);
		
		Optional<UsuariosEntity> findByTelefono(BigInteger tel);
		
		Optional<UsuariosEntity> findByNomUsuario(String usuario);
}
