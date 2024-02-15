package com.ec.service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioTO {

    private String nombre;
    private String apellido;
    private String email;
    private String cedula;
    private String telefono;
    private String direccion;
    private String tipo;
    private String password;
    private String identificador;

}
