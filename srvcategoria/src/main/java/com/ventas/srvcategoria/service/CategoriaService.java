package com.ventas.srvcategoria.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ventas.modelcore.dto.categoriaPago.CategoriaPagoDTO;
import com.ventas.modelcore.dto.generic.GenericResponseDTO;
import com.ventas.modelcore.entities.categoriaPago.CategoriaPagoDAO;
import com.ventas.srvcategoria.commons.converter.CategoriaConverter;
import com.ventas.srvcategoria.repository.ICategoriaRepository;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class CategoriaService implements ICategoriaService{

    //para los servicios instanciamos el repositorio, el modelmapper, el converter y el logger para swagger, un objectmapepr tambien y en el constructor
    //los instanciamos
    private final ICategoriaRepository iCategoriaRepository;
    private final ModelMapper modelMapper;
    private final CategoriaConverter categoriaConverter;
    private static final Logger logger = LoggerFactory.getLogger(CategoriaService.class);

    private ObjectMapper mapper = new ObjectMapper();

    //constructor lleva un autowired
    @Autowired
    public CategoriaService(CategoriaConverter categoriaConverter, ModelMapper modelMapper, ICategoriaRepository iCategoriaRepository) {
        this.categoriaConverter = categoriaConverter;
        this.iCategoriaRepository = iCategoriaRepository;
        this.modelMapper = modelMapper;


    }

    //CREAR
    @Override
    public GenericResponseDTO crearCategoria(CategoriaPagoDTO categoriaPagoDTO) throws Exception {
        try{
            CategoriaPagoDAO categoriaPagoDAO = categoriaConverter.categoriaPagoDTOtoDAO(categoriaPagoDTO, modelMapper);
            logger.info(mapper.writeValueAsString(categoriaPagoDAO));
            //guarda la categoria
            iCategoriaRepository.save(categoriaPagoDAO);
            //Se crea un DTO de respuesta
            CategoriaPagoDTO categoriaPagoDTORespuesta = categoriaConverter.categoriaPagoDAOtoDTO(categoriaPagoDAO, modelMapper);
            logger.info(mapper.writeValueAsString(categoriaPagoDTO));
            return GenericResponseDTO.builder().message("Se creo la categoria de pago").objectResponse(categoriaPagoDTORespuesta).statusCode(HttpStatus.OK.value()).build();
        }catch(Exception e){
            logger.error(e.getMessage());
            return GenericResponseDTO.builder().message("Error al crear la Categoria Pago").objectResponse(null).statusCode(HttpStatus.BAD_REQUEST.value()).build();
        }
    }

    //EDITAR
    @Override
    public GenericResponseDTO editarCategoria(CategoriaPagoDTO categoriaPagoDTO) throws Exception {
        try{
            if(categoriaPagoDTO.getId() != null && iCategoriaRepository.existsById(categoriaPagoDTO.getId())) {
                CategoriaPagoDAO categoriaPagoDAO = categoriaConverter.categoriaPagoDTOtoDAO(categoriaPagoDTO, modelMapper);
                logger.info(mapper.writeValueAsString(categoriaPagoDAO));
                //guarda la categoria
                iCategoriaRepository.save(categoriaPagoDAO);
                //Se crea un DTO de respuesta
                CategoriaPagoDTO categoriaPagoDTORespuesta = categoriaConverter.categoriaPagoDAOtoDTO(categoriaPagoDAO, modelMapper);
                logger.info(mapper.writeValueAsString(categoriaPagoDTO));
                return GenericResponseDTO.builder().message("Se edito la categoria de pago").objectResponse(categoriaPagoDTORespuesta).statusCode(HttpStatus.OK.value()).build();
            }else{
                return GenericResponseDTO.builder().message("Error al editar la Categoria Pago").objectResponse(null).statusCode(HttpStatus.BAD_REQUEST.value()).build();
            }
        }catch(Exception e){
            logger.error(e.getMessage());
            return GenericResponseDTO.builder().message("Error al crear la Categoria Pago").objectResponse(null).statusCode(HttpStatus.BAD_REQUEST.value()).build();
        }
    }


    @Override
    public GenericResponseDTO listarCategoria() throws Exception {
        try{
                List<CategoriaPagoDTO> listaCategoriaDTO = Arrays.asList(modelMapper.map(iCategoriaRepository.findAll(), CategoriaPagoDTO[].class));
                logger.info(mapper.writeValueAsString(listaCategoriaDTO));
            return GenericResponseDTO.builder().message("Listado Categorias de pagos existentes").objectResponse(listaCategoriaDTO).statusCode(HttpStatus.OK.value()).build();
        }catch(Exception e){
            logger.error(e.getMessage());
            return GenericResponseDTO.builder().message("Error al al listar la Categoria Pago").objectResponse(null).statusCode(HttpStatus.BAD_REQUEST.value()).build();
        }
    }

}
