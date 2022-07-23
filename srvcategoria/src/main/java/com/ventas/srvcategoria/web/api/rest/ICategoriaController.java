package com.ventas.srvcategoria.web.api.rest;

import com.ventas.modelcore.dto.categoriaPago.CategoriaPagoDTO;
import com.ventas.modelcore.dto.generic.GenericResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.List;

public interface ICategoriaController {

    ResponseEntity<GenericResponseDTO> crearCategoria(@Valid @RequestBody CategoriaPagoDTO categoriaPagoDTO) throws Exception;

    ResponseEntity<GenericResponseDTO> editarCategoria(@Valid @RequestBody CategoriaPagoDTO categoriaPagoDTO) throws Exception;

    ResponseEntity<GenericResponseDTO> listarCategoria() throws Exception;
}
