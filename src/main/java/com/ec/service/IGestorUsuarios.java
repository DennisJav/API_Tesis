package com.ec.service;

import com.ec.entity.Usuario;

public interface IGestorUsuarios {

    void crearUsuario(String nombre, String apellido, String email, String cedula, String telefono, String direccion,String tipo);
    void actualizarUsuario(Integer id, String nombre, String apellido, String cedula,String telefono, String email, String direccion);

}
