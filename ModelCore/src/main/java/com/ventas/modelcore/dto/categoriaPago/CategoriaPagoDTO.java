package com.ventas.modelcore.dto.categoriaPago;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.*;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"categoriapago_id", "categoriapago_nombre"})
public class CategoriaPagoDTO {

    private Long id;

    @NotNull(message = "El nombre de la categoria de pago es requerido")
    @Size(min = 1, max = 100, message ="La longitud de la categoria debe estar entre 1 y 50 caracteres")
    private String nombreCategoriaPago;
}

