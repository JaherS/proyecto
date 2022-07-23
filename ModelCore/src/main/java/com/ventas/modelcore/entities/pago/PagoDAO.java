package com.ventas.modelcore.entities.pago;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.ventas.modelcore.entities.categoriaPago.CategoriaPagoDAO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "Pago")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class PagoDAO implements Serializable {


    public static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;

    @Column(name = "estado", nullable=false, length=100)
    private String estadoPago;

    @Column(name = "valor_pago", nullable=false)
    private double valorPago;

    @Temporal(TemporalType.DATE)
    @Column(name = "fecha_pago", nullable=false, length=7)
    private Date fechaPago;


    @JoinColumn(name = "id_categoria_pago", referencedColumnName = "id", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private CategoriaPagoDAO categoriaPago;


}

