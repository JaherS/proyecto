package com.ventas.modelcore.dto.generic;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

//Mensaje para responder si se ejecuto correctamente o no
@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)

public class GenericResponseDTO {

    public String message;
    public Object objectResponse;
    public int statusCode;
}
