package com.ventas.srvpago.service;


import com.ventas.modelcore.dto.generic.GenericResponseDTO;
import com.ventas.modelcore.dto.pago.PagoDTO;

public interface IPagoService {

    GenericResponseDTO crearPago(PagoDTO pagoDTO) throws Exception;

    GenericResponseDTO listarPagos() throws Exception;

    GenericResponseDTO editarPago(PagoDTO pagoDTO) throws Exception;

    GenericResponseDTO consultarPagosActivos() throws Exception;
}
