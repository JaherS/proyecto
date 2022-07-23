package com.ventas.modelcore.dto.pago;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.ventas.modelcore.dto.categoriaPago.CategoriaPagoDTO;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"pago_id", "pago_estado", "pago_valor", "pago_fecha, categoriapago_id"})
public class PagoDTO {

    private Long id;

    @NotNull(message = "El estado de pago es requerido")
    private String estadoPago;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull(message = "la fecha de pago es requerido")
    private Date fechaPago;

    @NotNull(message = "El valor del pago es requerido")
    private double valorPago;

    @NotNull(message = "Seleccione una categoria de pago")
    private CategoriaPagoDTO categoriaPago;

}