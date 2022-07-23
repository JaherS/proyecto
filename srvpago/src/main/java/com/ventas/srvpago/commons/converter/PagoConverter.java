package com.ventas.srvpago.commons.converter;


import com.ventas.modelcore.dto.pago.PagoDTO;
import com.ventas.modelcore.entities.pago.PagoDAO;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

//con el Component le indicamos a spring que cree una instancia de estas dos clases de modelmapper para convertir de DTO a DAO y viceversa y que Spring las gestione
//para cuando sean necesarias utilizarlas, es decir cuando algun servicio necesite esto ya se encuentra listo para utilizar y spring va y lo inyecta
@Component
public class PagoConverter {

    public PagoDAO pagoDTOtoDAO(PagoDTO pagoDTO, ModelMapper modelMapper){
        PagoDAO pagoDAO = new PagoDAO();
        modelMapper.map(pagoDTO, pagoDAO);
        return pagoDAO;
    }

    public PagoDTO pagoDAOtoDTO(PagoDAO pagoDAO, ModelMapper modelMapper){
        PagoDTO pagoDTO = new PagoDTO();
        modelMapper.map(pagoDAO, pagoDTO);
        return pagoDTO;
    }
}