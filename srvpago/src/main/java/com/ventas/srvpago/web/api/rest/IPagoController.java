package com.ventas.srvpago.web.api.rest;


import com.ventas.modelcore.dto.generic.GenericResponseDTO;
import com.ventas.modelcore.dto.pago.PagoDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

public interface IPagoController {

    ResponseEntity<GenericResponseDTO> crearPago(@Valid @RequestBody PagoDTO pagoDTO) throws Exception;

    ResponseEntity<GenericResponseDTO> listarPagos() throws Exception;

    ResponseEntity<GenericResponseDTO> editarPago(@Valid @RequestBody PagoDTO pagoDTO) throws Exception;

    ResponseEntity<GenericResponseDTO> consultarPagosActivos() throws Exception;
}
