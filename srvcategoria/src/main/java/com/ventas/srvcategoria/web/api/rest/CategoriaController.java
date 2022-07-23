package com.ventas.srvcategoria.web.api.rest;

import com.ventas.modelcore.dto.categoriaPago.CategoriaPagoDTO;
import com.ventas.modelcore.dto.generic.GenericResponseDTO;
import com.ventas.srvcategoria.service.ICategoriaService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequestMapping("/v1")
@CrossOrigin
public class CategoriaController implements ICategoriaController{

    @Autowired
    private ICategoriaService iCategoriaService;

    @Override
    @PostMapping(path = "/crearCategoria", produces = "application/json", consumes = "application/json")
    @ApiOperation(value = "Crea una nueva  Categoria en el sistema", notes = "notas")
    @ApiResponses(value = {
    @ApiResponse(code = 200, message = "La creacion fue exitosa", response = GenericResponseDTO.class)
    })
    public ResponseEntity<GenericResponseDTO> crearCategoria(@Valid @RequestBody @ApiParam(type = "CategoriaPagoDTO", value = "{\n" +
            "\"nombre\": \"Auxiliar\",\n" +
            "\"activo\": \"1\",\n" +
            "\"idUsuarioRegistro\": \"55889966\",\n" + //<---- crear un json de ejemplo y pegarlo aca
            "\"idSesionRegistro\": \"33255\"\n" +
            "}", required = true) CategoriaPagoDTO categoriaPagoDTO) throws Exception{

        GenericResponseDTO genericResponseDTO = iCategoriaService.crearCategoria(categoriaPagoDTO);
        return new ResponseEntity(
                genericResponseDTO, HttpStatus.valueOf(genericResponseDTO.getStatusCode())
        );

    }

    @Override
    @PostMapping(path = "/editarCategoria", produces = "application/json", consumes = "application/json")
    @ApiOperation(value = "Editar la Categoria en el sistema", notes = "notas")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La actualizacion fue exitosa", response = GenericResponseDTO.class)
    })
    public ResponseEntity<GenericResponseDTO> editarCategoria(@Valid @RequestBody @ApiParam(type = "CategoriaPagoDTO", value = "Ejemplo json\n{\n" +
            "\"id\": \"2\",\n" +
            "\"nombre_categoria_pago\": \"Credito Alto\",\n" +
            "}", required = true) CategoriaPagoDTO categoriaPagoDTO) throws Exception{

        GenericResponseDTO genericResponseDTO = iCategoriaService.editarCategoria(categoriaPagoDTO);
        return new ResponseEntity(
                genericResponseDTO, HttpStatus.valueOf(genericResponseDTO.getStatusCode())
        );

    }

    @Override
    @GetMapping(path = "/listarCategoria")
    @ApiOperation(value = "Listar Categorias", notes = "notas")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Se listo correctamente", response = GenericResponseDTO.class)
    })
    public ResponseEntity<GenericResponseDTO> listarCategoria() throws Exception{

        GenericResponseDTO genericResponseDTO = iCategoriaService.listarCategoria();
        return new ResponseEntity(
                genericResponseDTO, HttpStatus.valueOf(genericResponseDTO.getStatusCode())
        );

    }


}
