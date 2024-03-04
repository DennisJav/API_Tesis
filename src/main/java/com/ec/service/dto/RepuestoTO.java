package com.ec.service.dto;

import com.ec.entity.Proveedor;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RepuestoTO extends RepresentationModel<RepuestoTO> implements Serializable {

    private static final long serialVersionUID =1L;

    private Integer id;
    private String tipo;
    private BigDecimal precio;
    private String nombre;
    private Integer stock;
    private String codBarras;
    @JsonIgnore
    private Proveedor proveedor;
    private BigDecimal subTotal;
    private Boolean estado;

   private String nombreEmpresa;
   private String identificacionEmpresa;
}
