package com.ventas.srvcategoria.service;

import com.ventas.modelcore.dto.categoriaPago.CategoriaPagoDTO;
import com.ventas.modelcore.dto.generic.GenericResponseDTO;

public interface ICategoriaService {

    GenericResponseDTO crearCategoria(CategoriaPagoDTO categoriaPagoDTO) throws Exception;

    GenericResponseDTO editarCategoria(CategoriaPagoDTO categoriaPagoD) throws Exception;


   GenericResponseDTO listarCategoria() throws Exception;
}
