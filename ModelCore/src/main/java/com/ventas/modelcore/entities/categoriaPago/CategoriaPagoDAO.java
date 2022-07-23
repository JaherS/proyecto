package com.ventas.modelcore.entities.categoriaPago;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "CategoriaPago")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class CategoriaPagoDAO implements Serializable {

    public static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) //ORIGINALMENTE DEBE IR GenerationType.IDENTITY PARA QUE LA BASE GENERE EL ID
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;

    @Column(name = "nombre_categoria_pago", nullable=false, unique = true, length=100)
    private String nombreCategoriaPago;
}