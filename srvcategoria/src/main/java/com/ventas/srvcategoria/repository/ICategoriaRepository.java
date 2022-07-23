package com.ventas.srvcategoria.repository;


import com.ventas.modelcore.entities.categoriaPago.CategoriaPagoDAO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICategoriaRepository extends JpaRepository<CategoriaPagoDAO, Long>{
/**
    @Query("select terminoCargo from TerminoCargoDAO terminoCargo where terminoCargo.activo = '1' order by terminoCargo.nombre")
    List<TerminoCargoDAO> consultarTodosActivos();

    List<TerminoCargoDAO> findAllByOrderByNombreAsc();
    **/


}
