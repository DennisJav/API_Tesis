package com.ec.service.dto;



import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProveedorTO implements Serializable {

    private static final long serialVersionUID =1L;

    private String nombreEmpresa;
    private String tipoIdentificacion;
    private String identificacion;
    private String telefono;
    private String correo;
    private LocalDateTime fechaRegistro;
    private String origen;

}
