package com.ventas.srvpago.web.api.rest;



import com.ventas.modelcore.dto.categoriaPago.CategoriaPagoDTO;
import com.ventas.modelcore.dto.generic.GenericResponseDTO;
import com.ventas.modelcore.dto.pago.PagoDTO;
import com.ventas.srvpago.service.IPagoService;
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
public class PagoController implements IPagoController{

    @Autowired
    private IPagoService iPagoService;

    @Override
    @PostMapping(path = "/crearPago", produces = "application/json", consumes = "application/json")
    @ApiOperation(value = "Crea un Pago en el sistema", notes = "notas")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La creacion fue exitosa", response = GenericResponseDTO.class)
    })
    public ResponseEntity<GenericResponseDTO> crearPago(@Valid @RequestBody @ApiParam(type = "PagoDTO", value = "{\n" +
            "\"nombre\": \"Auxiliar\",\n" +
            "\"activo\": \"1\",\n" +
            "\"idUsuarioRegistro\": \"55889966\",\n" + //<---- crear un json de ejemplo y pegarlo aca
            "\"idSesionRegistro\": \"33255\"\n" +
            "}", required = true) PagoDTO pagoDTO) throws Exception{

        GenericResponseDTO genericResponseDTO = iPagoService.crearPago(pagoDTO);
        return new ResponseEntity(
                genericResponseDTO, HttpStatus.valueOf(genericResponseDTO.getStatusCode())
        );

    }

    @Override
    @GetMapping(path = "/listarPagos")
    @ApiOperation(value = "Listar Pagos", notes = "notas")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Se listo correctamente", response = GenericResponseDTO.class)
    })
    public ResponseEntity<GenericResponseDTO> listarPagos() throws Exception{

        GenericResponseDTO genericResponseDTO = iPagoService.listarPagos();
        return new ResponseEntity(
                genericResponseDTO, HttpStatus.valueOf(genericResponseDTO.getStatusCode())
        );

    }

    @Override
    @PostMapping(path = "/editarPago", produces = "application/json", consumes = "application/json")
    @ApiOperation(value = "Editar el Pago en el sistema", notes = "notas")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La actualizacion fue exitosa", response = GenericResponseDTO.class)
    })
    public ResponseEntity<GenericResponseDTO> editarPago(@Valid @RequestBody @ApiParam(type = "PagoDTO", value = "Ejemplo json\n{\n" +
            "\"categoriaPago\": {\n" +
            "\"id\": \"15\",\n" +
            "\"nombreCategoriaPago\": \"Credito Alto\",\n" +
            "\"}\",\n" +
            "\"estadoPago\": \"ACTIVO\",\n" +
            "\"fechaPago\": \"2022-07-19T02:10:12.039Z\"\n" +
            "\"id\": 10\"{\n" +
            "\"valorPago\": \"150.000\",\n" +
            "}", required = true) PagoDTO pagoDTO) throws Exception{

        GenericResponseDTO genericResponseDTO = iPagoService.editarPago(pagoDTO);
        return new ResponseEntity(
                genericResponseDTO, HttpStatus.valueOf(genericResponseDTO.getStatusCode())
        );

    }

    @Override
    @GetMapping(path = "/consultarPagosActivos")
    @ApiOperation(value = "Listar Pagos Activos", notes = "notas")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Se listo correctamente", response = GenericResponseDTO.class)
    })
    public ResponseEntity<GenericResponseDTO> consultarPagosActivos() throws Exception{

        GenericResponseDTO genericResponseDTO = iPagoService.consultarPagosActivos();
        return new ResponseEntity(
                genericResponseDTO, HttpStatus.valueOf(genericResponseDTO.getStatusCode())
        );

    }

}
