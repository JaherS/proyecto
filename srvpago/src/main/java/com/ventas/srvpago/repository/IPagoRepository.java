package com.ventas.srvpago.repository;

import com.ventas.modelcore.entities.pago.PagoDAO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IPagoRepository extends JpaRepository<PagoDAO, Long> {
/**
     @Query("select terminoCargo from TerminoCargoDAO terminoCargo where terminoCargo.activo = '1' order by terminoCargo.nombre")
     List<TerminoCargoDAO> consultarTodosActivos();

     List<TerminoCargoDAO> findAllByOrderByNombreAsc();

**/
    @Query("select pagoDAO from PagoDAO pagoDAO where pagoDAO.estadoPago='ACTIVO' order by pagoDAO.valorPago desc")
    List<PagoDAO> consultarPagosActivos();
}
