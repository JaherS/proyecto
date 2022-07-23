package com.ventas.srvcategoria.commons.converter;

import com.ventas.modelcore.dto.categoriaPago.CategoriaPagoDTO;
import com.ventas.modelcore.entities.categoriaPago.CategoriaPagoDAO;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CategoriaConverter {

    public CategoriaPagoDAO categoriaPagoDTOtoDAO(CategoriaPagoDTO categoriaPagoDTO, ModelMapper modelMapper){
        CategoriaPagoDAO categoriaPagoDAO = new CategoriaPagoDAO();
        modelMapper.map(categoriaPagoDTO, categoriaPagoDAO);
        return categoriaPagoDAO;
    }

    public CategoriaPagoDTO categoriaPagoDAOtoDTO(CategoriaPagoDAO categoriaPagoDAO, ModelMapper modelMapper){
        CategoriaPagoDTO categoriaPagoDTO = new CategoriaPagoDTO();
        modelMapper.map(categoriaPagoDAO, categoriaPagoDTO);
        return categoriaPagoDTO;
    }


}
