package com.ventas.srvpago.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ventas.modelcore.dto.categoriaPago.CategoriaPagoDTO;
import com.ventas.modelcore.dto.generic.GenericResponseDTO;
import com.ventas.modelcore.dto.pago.PagoDTO;
import com.ventas.modelcore.entities.categoriaPago.CategoriaPagoDAO;
import com.ventas.modelcore.entities.pago.PagoDAO;
import com.ventas.srvpago.commons.converter.PagoConverter;
import com.ventas.srvpago.repository.IPagoRepository;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class PagoService implements IPagoService{

    private final IPagoRepository iPagoRepository;

    private final ModelMapper modelMapper;

    private final PagoConverter pagoConverter;

    private static final Logger logger = LoggerFactory.getLogger(PagoService.class);

    private ObjectMapper mapper = new ObjectMapper();

    @Autowired
    public PagoService(IPagoRepository iPagoRepository, ModelMapper modelMapper, PagoConverter pagoConverter) {
        this.iPagoRepository = iPagoRepository;
        this.modelMapper = modelMapper;
        this.pagoConverter = pagoConverter;
    }

    @Override
    public GenericResponseDTO crearPago(PagoDTO pagoDTO) throws Exception {
        try{
            PagoDAO pagoDAO = pagoConverter.pagoDTOtoDAO(pagoDTO, modelMapper);
            logger.info(mapper.writeValueAsString(pagoDAO));
            //guarda la categoria
            iPagoRepository.save(pagoDAO);
            //Se crea un DTO de respuesta
            PagoDTO pagoDTORespuesta = pagoConverter.pagoDAOtoDTO(pagoDAO, modelMapper);
            logger.info(mapper.writeValueAsString(pagoDTO));
            return GenericResponseDTO.builder().message("Se creo el Pago").objectResponse(pagoDTORespuesta).statusCode(HttpStatus.OK.value()).build();
        }catch(Exception e){
            logger.error(e.getMessage());
            return GenericResponseDTO.builder().message("Error al crear el Pago").objectResponse(null).statusCode(HttpStatus.BAD_REQUEST.value()).build();
        }
    }

    @Override
    public GenericResponseDTO listarPagos() throws Exception {
        try{
            List<PagoDTO> listaPagosDTO = Arrays.asList(modelMapper.map(iPagoRepository.findAll(), PagoDTO[].class));
            logger.info(mapper.writeValueAsString(listaPagosDTO));
            return GenericResponseDTO.builder().message("Listado de Pagos existentes").objectResponse(listaPagosDTO).statusCode(HttpStatus.OK.value()).build();
        }catch(Exception e){
            logger.error(e.getMessage());
            return GenericResponseDTO.builder().message("Error al al listar los pagos").objectResponse(null).statusCode(HttpStatus.BAD_REQUEST.value()).build();
        }
    }


    @Override
    public GenericResponseDTO editarPago(PagoDTO pagoDTO) throws Exception {
        try{
            if(pagoDTO.getId() != null && iPagoRepository.existsById(pagoDTO.getId())) {
                PagoDAO pagoDAO = pagoConverter.pagoDTOtoDAO(pagoDTO, modelMapper);
                logger.info(mapper.writeValueAsString(pagoDAO));
                //guarda la categoria
                iPagoRepository.save(pagoDAO);
                //Se crea un DTO de respuesta
                PagoDTO pagoDTORespuesta = pagoConverter.pagoDAOtoDTO(pagoDAO, modelMapper);
                logger.info(mapper.writeValueAsString(pagoDTO));
                return GenericResponseDTO.builder().message("Se edito el pago").objectResponse(pagoDTORespuesta).statusCode(HttpStatus.OK.value()).build();
            }else{
                return GenericResponseDTO.builder().message("Error al editar el Pago").objectResponse(null).statusCode(HttpStatus.BAD_REQUEST.value()).build();
            }
        }catch(Exception e){
            logger.error(e.getMessage());
            return GenericResponseDTO.builder().message("Error al editar el Pago").objectResponse(null).statusCode(HttpStatus.BAD_REQUEST.value()).build();
        }
    }

    @Override
    public GenericResponseDTO consultarPagosActivos() throws Exception {
        try{
            List<PagoDTO> listaPagosDTO = Arrays.asList(modelMapper.map(iPagoRepository.consultarPagosActivos(), PagoDTO[].class));
            logger.info(mapper.writeValueAsString(listaPagosDTO));
            return GenericResponseDTO.builder().message("Listado de Pagos Activos").objectResponse(listaPagosDTO).statusCode(HttpStatus.OK.value()).build();
        }catch(Exception e){
            logger.error(e.getMessage());
            return GenericResponseDTO.builder().message("Error al al listar los Pagos Activos").objectResponse(null).statusCode(HttpStatus.BAD_REQUEST.value()).build();
        }
    }
}
