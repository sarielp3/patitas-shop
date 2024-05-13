package com.patitas.mascotas.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.patitas.mascotas.models.ArticulosEntity;

@Repository
public interface ArticulosRepository extends JpaRepository<ArticulosEntity, Integer> {
	
	@Query("SELECT v FROM ArticulosEntity v")
	List<ArticulosEntity> getAll();
	
	@Modifying
    @Query("UPDATE ArticulosEntity h SET h.status = :status WHERE idArticulo = :idArticulo")
    void updateEstatusArticulo(@Param("idArticulo")Long idArticulo, @Param("status")Character status);
	
}
